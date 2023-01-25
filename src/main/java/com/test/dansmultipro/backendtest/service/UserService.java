package com.test.dansmultipro.backendtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.test.dansmultipro.backendtest.entity.User;
import com.test.dansmultipro.backendtest.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void save(String username, String password) {
        User user = new User()
                        .setUsername(username)
                        .setPassword(password);
        userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow();
    }

    public boolean isValidLogin(String username, String password) {
        User user = findByUsername(username);
        if (user != null) {
            return user.getUsername().equals(username) && isPasswordMatch(password, user.getPassword());
        } else {
            return false;
        }
    }

    private boolean isPasswordMatch(String plainText, String hash) {
        return BCrypt.checkpw(plainText, hash);
    }
}
