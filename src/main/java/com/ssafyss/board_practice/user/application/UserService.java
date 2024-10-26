package com.ssafyss.board_practice.user.application;

import com.ssafyss.board_practice.user.domain.User;
public interface UserService {

    public User login(String email);

    public void logout();

    boolean checkPassword(String rawPassword, String encodedPassword);
}
