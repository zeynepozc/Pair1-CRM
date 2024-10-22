package com.etiya.userservice.service.auth;

import com.etiya.userservice.service.dto.LoginRequest;
import com.etiya.userservice.service.dto.TokenResponse;

public interface AuthService {
    TokenResponse login(LoginRequest loginRequest);
    String encodePassword(String password);
}
