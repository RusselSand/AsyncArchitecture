package com.popug.accounting.config;

import com.popug.accounting.jwt.JwtAdminFilter;
import com.popug.accounting.jwt.JwtUserFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

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
