package com.etiya.userservice.service.auth;

import com.etiya.userservice.service.dto.LoginRequest;
import com.etiya.userservice.service.dto.TokenResponse;
import com.etiya.userservice.service.user.UserService;
import io.github.cagataysero.security.BaseJwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final BaseJwtService baseJwtService;

    @Override
    public TokenResponse login(LoginRequest loginRequest) {
        List<String> roles = new ArrayList<>();
        UserDetails user = userService.loadUserByUsername(loginRequest.getEmail());
        boolean passwordMatching = passwordEncoder.matches(loginRequest.getPassword(), user.getPassword());
        if(!passwordMatching)
            throw new RuntimeException("E-posta veya şifre hatalı.");

        return new TokenResponse(baseJwtService.generateToken(user.getUsername(),roles), true);
    }

    @Override
    public String encodePassword(String password){
        return passwordEncoder.encode(password);
    }
}
