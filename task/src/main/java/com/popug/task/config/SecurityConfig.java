package com.popug.task.config;

import com.popug.task.jwt.JwtAdminFilter;
import com.popug.task.jwt.JwtUserFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtUserFilter jwtAuthFilter;
    private final JwtAdminFilter jwtAdminFilter;

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
//        http.authorizeHttpRequests().requestMatchers("api/v1/task/assign")
//                .authenticated().and().addFilterBefore(jwtAdminFilter, UsernamePasswordAuthenticationFilter.class);
//        return http.build();
//    }
}
