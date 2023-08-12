package com.popug.task.jwt;


import com.popug.task.kafka.UserConsumer;
import com.popug.task.model.Role;
import com.popug.task.model.User;
import com.popug.task.service.UserService;
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
public class JwtUserFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserService userService;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserConsumer.class);
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
        if(user == null){
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
    }
}

