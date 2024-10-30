package com.etiya.userservice.service.auth;

import com.etiya.userservice.entity.User;
import com.etiya.userservice.service.dto.LoginRequest;
import com.etiya.userservice.service.dto.TokenResponse;
import com.etiya.userservice.service.user.UserService;
import io.github.cagataysero.security.BaseJwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        User user = (User) userService.loadUserByUsername(loginRequest.getEmail());

        if (!user.isAccountNonLocked())
            throw new LockedException("Hesap askiya alindi.");

        if (user.getLoginAttempts() == 3){
            user.setAccountLocked(true);
            user.setLockedDate(LocalDateTime.now());
            userService.save(user);
            throw new LockedException("Hesap askiya alindi.");
        }

        boolean passwordMatching = passwordEncoder.matches(loginRequest.getPassword(), user.getPassword());
        if(!passwordMatching) {
            user.setLoginAttempts(user.getLoginAttempts() + 1);
            userService.save(user);
            throw new BadCredentialsException("E-posta veya şifre hatalı.");
        } else {
            user.setLoginAttempts(0);
            userService.save(user);
        }
        return new TokenResponse(baseJwtService.generateToken(user.getUsername()), true);
    }

    @Override
    public String encodePassword(String password){
        return passwordEncoder.encode(password);
    }
}
