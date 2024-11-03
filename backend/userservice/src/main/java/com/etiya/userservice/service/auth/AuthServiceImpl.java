package com.etiya.userservice.service.auth;

import com.etiya.userservice.entity.User;
import com.etiya.userservice.rule.AuthBusinessRules;
import com.etiya.userservice.service.dto.LoginRequest;
import com.etiya.userservice.service.dto.TokenResponse;
import com.etiya.userservice.service.user.UserService;
import io.github.cagataysero.security.BaseJwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserService userService;
    private final AuthBusinessRules authBusinessRules;
    private final PasswordEncoder passwordEncoder;
    private final BaseJwtService baseJwtService;

    @Override
    public TokenResponse login(LoginRequest loginRequest) {
        User user = (User) userService.loadUserByUsername(loginRequest.getEmail());

        authBusinessRules.userWithUsernameNotExists(user);
        authBusinessRules.isUserAccountLocked(user);
        authBusinessRules.isLoginAttemptsEqualsThree(user);
        authBusinessRules.isPasswordMatching(user, loginRequest.getPassword());

        user.setLoginAttempts(0);
        userService.save(user);

        return new TokenResponse(baseJwtService.generateToken(user.getUsername()), true);
    }

    @Override
    public String encodePassword(String password){
        return passwordEncoder.encode(password);
    }
}
