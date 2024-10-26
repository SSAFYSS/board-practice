package com.ssafyss.board_practice.user.presentation;

import com.ssafyss.board_practice.user.domain.User;

public class LoginUserResponse {
    private User user;
    private String msg;

    public LoginUserResponse(User user, String msg) {
        this.user = user;
        this.msg = msg;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
