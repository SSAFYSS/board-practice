package com.ssafyss.board_practice.domain.user.application;

import com.ssafyss.board_practice.domain.user.dto.SignInResponse;

public interface UserService {
    void checkEmail(String email);

    void signUp(String email, String password);

    SignInResponse signIn(String email, String password);
}
