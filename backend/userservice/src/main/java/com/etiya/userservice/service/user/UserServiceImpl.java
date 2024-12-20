package com.etiya.userservice.service.user;

import com.etiya.userservice.entity.User;
import com.etiya.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username){
        return userRepository.findByEmail(username).orElse(null);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }


}
