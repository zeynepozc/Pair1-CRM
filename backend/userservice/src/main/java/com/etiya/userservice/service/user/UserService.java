package com.etiya.userservice.service.user;

import com.etiya.userservice.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {
    UserDetails loadUserByUsername(String username) ;

    void save(User user);

}
