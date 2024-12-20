package com.etiya.userservice.controller;

import com.etiya.userservice.service.auth.AuthService;
import com.etiya.userservice.service.dto.LoginRequest;
import com.etiya.userservice.service.dto.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("login")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(authService.login(loginRequest));
    }

    @PostMapping("encode")
    public String login(@RequestBody String password){
        return authService.encodePassword(password);
    }
}
