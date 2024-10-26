package com.ssafyss.board_practice.domain.auth.dto;

public class SignInRequest {
    private String email;
    private String password;

    public SignInRequest() {

    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
