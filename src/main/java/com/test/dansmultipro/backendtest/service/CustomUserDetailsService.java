package com.test.dansmultipro.backendtest.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User hardCodedUser = new User("test", "test", new ArrayList<>());
        if (!hardCodedUser.getUsername().equals(username)) {
            log.error("Incorrect Credentials");
            throw new UsernameNotFoundException("Incorrect Credentials.");
        }
        return hardCodedUser;
    }
}
