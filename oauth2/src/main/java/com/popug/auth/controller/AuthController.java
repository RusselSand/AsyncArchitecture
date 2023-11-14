package com.popug.auth.controller;

import com.popug.auth.auth.AuthRequest;
import com.popug.auth.auth.AuthResponse;
import com.popug.auth.auth.ChangeRoleRequest;
import com.popug.auth.auth.RegisterRequest;
import com.popug.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService service;
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest request){
        return ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/change")
    public ResponseEntity<AuthResponse> changeRole(@RequestBody ChangeRoleRequest request){
        return ResponseEntity.ok(service.changeRole(request));
    }
}
