package com.popug.auth.model;

import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public UserDto toDto(User entity){
        return new UserDto(entity.getPublicId(), entity.getName(), entity.getEmail(), entity.getRole().toString());
    }
}
