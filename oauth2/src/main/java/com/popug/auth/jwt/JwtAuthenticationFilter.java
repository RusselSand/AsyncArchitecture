package com.popug.auth.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;  //to fetch the user from DB

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {
        //bc when we make a call, we need to pass the JWT authentication token within the header,
        // so it should be within a header called authorization(this is the header that contains JWT token/ Bearer token)
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String userEmail;
        //The Bearer token should always start with the keyword Bearer
        if (authHeader == null || !authHeader.startsWith("Bearer")){
            filterChain.doFilter(request,response); //pass the request & response to the next filter
            return;
        }
        //Extract the token from the header
        jwt = authHeader.substring(7); //bc Bearer + space = 7
        //Extract user email from JWT token
        userEmail = jwtService.extractUserName(jwt);
        //Check if the user is already connected (authenticated)
        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail); //Get user details from DB
            //Check if the token is still valid or not
            if (jwtService.isTokenValid(jwt, userDetails)){
                //Update the security context + send the request to the DispatcherServlet
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                SecurityContextHolder.getContext().setAuthentication(authToken); //Update the Authentication token
            }
            filterChain.doFilter(request, response); //Pass the hand to the next filter to be executed
        }
    }
}
