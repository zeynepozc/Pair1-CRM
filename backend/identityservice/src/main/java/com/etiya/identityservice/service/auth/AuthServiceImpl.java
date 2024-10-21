package com.etiya.identityservice.service.auth;

import com.etiya.identityservice.dto.LoginRequest;
import com.etiya.identityservice.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService
{
    //private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    //private final BaseJwtService baseJwtService;

    @Override
    public String login(LoginRequest loginRequest) {
        UserDetails user = userService.loadUserByUsername(loginRequest.getEmail());
        /*
        boolean passwordMatching = passwordEncoder.matches(loginRequest.getPassword(), user.getPassword());
        if(!passwordMatching)
            throw new RuntimeException("E-posta veya şifre hatalı.");

        return baseJwtService.generateToken(user.getUsername());
        */
        return null;
    }
}