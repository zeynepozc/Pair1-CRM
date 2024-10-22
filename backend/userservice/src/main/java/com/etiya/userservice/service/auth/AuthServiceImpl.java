package com.etiya.userservice.service.auth;

import com.etiya.userservice.service.dto.LoginRequest;
import com.etiya.userservice.service.dto.TokenResponse;
import com.etiya.userservice.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final BaseJwtService baseJwtService;

    @Override
    public TokenResponse login(LoginRequest loginRequest) {
        UserDetails user = userService.loadUserByUsername(loginRequest.getEmail());
        boolean passwordMatching = passwordEncoder.matches(loginRequest.getPassword(), user.getPassword());
        if(!passwordMatching)
            throw new RuntimeException("E-posta veya şifre hatalı.");

        return baseJwtService.generateToken(user.getUsername());
    }
}
