package com.popug.auth.service;

import com.popug.auth.auth.AuthRequest;
import com.popug.auth.auth.AuthResponse;
import com.popug.auth.auth.ChangeRoleRequest;
import com.popug.auth.auth.RegisterRequest;
import com.popug.auth.jwt.JwtService;
import com.popug.auth.kafka.UserLifeCycleProducer;
import com.popug.auth.messages.UserAddedMessage;
import com.popug.auth.model.Role;
import com.popug.auth.model.User;
import com.popug.auth.model.UserMapper;
import com.popug.auth.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepo repo;
    private final PasswordEncoder encoder;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;
    private final UserLifeCycleProducer userProducer;
    private final UserMapper userMapper;
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthService.class);

    public AuthResponse register(RegisterRequest request){
        var user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(encoder.encode(request.getPassword()))
                .role(Role.USER)
                .publicId(UUID.randomUUID().toString())
                .build();
        user = repo.save(user);
        sendUserToKafka(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder().token(jwtToken).build();
    }

    public AuthResponse authenticate(AuthRequest request){
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(), request.getPassword()
                )
        );
        var user = repo.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder().token(jwtToken).build();
    }

    public AuthResponse changeRole(ChangeRoleRequest request){
        var user = repo.findByEmail(request.getEmail()).orElseThrow();
        user.setRole(Role.MANAGER);
        repo.save(user);
        sendUserToKafka(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder().token(jwtToken).build();
    }
    private void sendUserToKafka(User user) {
        try {
            UserAddedMessage msg = UserAddedMessage.newBuilder()
                    .setPublicId(user.getPublicId())
                    .setEmail(user.getEmail())
                    .setName(user.getName())
                    .setRole(user.getRole().toString())
                    .build();
            userProducer.sendMessage(msg);
        } catch (Exception ex){
            LOGGER.warn("Error in convert to json: "+ ex.getMessage());
        }
    }
}
