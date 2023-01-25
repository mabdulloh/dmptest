package com.test.dansmultipro.backendtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.dansmultipro.backendtest.dto.JwtRequest;
import com.test.dansmultipro.backendtest.dto.JwtResponse;
import com.test.dansmultipro.backendtest.service.CustomUserDetailsService;
import com.test.dansmultipro.backendtest.util.JwtUtil;

@CrossOrigin
@RestController
public class JwtController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @RequestMapping({"/hello"})
    public String hello() {
        return "Welcome To Spring Security!";
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest request) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        } catch (AuthenticationException ex) {
            throw new Exception("Incorrect Credentials", ex);
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(jwt));

    }
}
