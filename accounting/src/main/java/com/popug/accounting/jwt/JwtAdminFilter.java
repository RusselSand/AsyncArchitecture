package com.popug.accounting.jwt;


import com.popug.accounting.kafka.UserLifeCycleConsumer;
import com.popug.accounting.model.Role;
import com.popug.accounting.model.User;
import com.popug.accounting.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAdminFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserService userService;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserLifeCycleConsumer.class);
    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        final String userEmail;
        if (authHeader == null){
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return;
        }
        userEmail = jwtService.extractUserName(authHeader.substring(0));
        User user = userService.getUser(userEmail);
        if(user == null || !user.getRole().equals(Role.MANAGER)){
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
    }
}

