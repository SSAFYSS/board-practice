package com.ssafyss.board_practice.domain.user.exception;

public class SignInFailedException extends RuntimeException {
    public SignInFailedException(String message) {
        super(message);
    }
}
