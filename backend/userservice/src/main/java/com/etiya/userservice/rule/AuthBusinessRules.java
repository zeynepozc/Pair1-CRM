package com.etiya.userservice.rule;

import com.etiya.userservice.entity.User;
import com.etiya.userservice.service.user.UserService;
import io.github.cagataysero.exception.type.BusinessException;
import io.github.cagataysero.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Component
public class AuthBusinessRules {
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final MessageService messageService;

    public void userWithUsernameNotExists(User user) {
        if (user == null)
            throw new BusinessException(messageService.getMessage("incorrect.credentials"));
    }


    public void isUserAccountLocked(User user) {
        if (!user.isAccountNonLocked()) {
            throw new BusinessException(messageService.getMessage("account.locked"));
        }
    }

    public void isLoginAttemptsEqualsThree(User user) {
        if(user.getLoginAttempts()==3)
        {
            user.setAccountLocked(true);
            user.setLockedDate(LocalDateTime.now());
            userService.save(user);
            throw new BusinessException(messageService.getMessage("account.locked"));
        }
    }

    public void isPasswordMatching(User user, String password){
        boolean passwordMatching = passwordEncoder.matches(password, user.getPassword());
        if (!passwordMatching) {
            user.setLoginAttempts(user.getLoginAttempts() + 1);
            userService.save(user);
            throw new BusinessException(messageService.getMessage("incorrect.credentials"));
        }
    }
}
