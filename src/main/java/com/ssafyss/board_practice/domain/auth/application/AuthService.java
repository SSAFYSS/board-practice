package com.ssafyss.board_practice.domain.auth.application;

import com.ssafyss.board_practice.domain.auth.dto.SignInResponse;

public interface AuthService {
    void checkEmail(String email);

    void signUp(String email, String password);

    SignInResponse signIn(String email, String password);
}
