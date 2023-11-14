package com.popug.auth.service;

import com.popug.auth.exception.UserNotFoundException;
import com.popug.auth.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService {
    public final UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username){
        return userRepo.findByEmail(username).orElseThrow(()->
                new UserNotFoundException("Could not find user with email: " + username));
    }
}
