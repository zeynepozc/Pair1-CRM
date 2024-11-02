package com.etiya.userservice.controller;

import com.etiya.userservice.service.auth.AuthService;
import com.etiya.userservice.service.dto.LoginRequest;
import com.etiya.userservice.service.dto.TokenResponse;
import io.github.cagataysero.exception.type.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Locale;


@RestController()
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final ResourceBundleMessageSource bundleMessageSource;

    @GetMapping("example")
    public ResponseEntity<String> example() {
        Locale currentLocale = LocaleContextHolder.getLocale();
        String message = bundleMessageSource.getMessage("hello", null, currentLocale);

        throw new BusinessException(message);
    }

    @PostMapping("login")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(authService.login(loginRequest));
    }

    @PostMapping("encode")
    public String login(@RequestBody String password){
        return authService.encodePassword(password);
    }
}
