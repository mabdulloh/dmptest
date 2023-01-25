package com.test.dansmultipro.backendtest.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    @NotBlank(message = "username can't blank")
    private String username;
    @NotBlank(message = "password can't blank")
    private String password;
}
