package com.ssafyss.board_practice.domain.user.application;

public interface UserService {
    void checkEmail(String email);

    void signUp(String email, String password);
}
