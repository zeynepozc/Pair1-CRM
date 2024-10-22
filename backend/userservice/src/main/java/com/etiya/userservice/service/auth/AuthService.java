package com.etiya.userservice.service.auth;

import com.etiya.userservice.service.dto.LoginRequest;

public interface AuthService {
    String login(LoginRequest loginRequest);
}
