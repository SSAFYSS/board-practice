package com.ssafyss.board_practice.domain.auth.api;

import com.ssafyss.board_practice.domain.auth.exception.DuplicatedEmailException;
import com.ssafyss.board_practice.domain.auth.exception.SignInFailedException;
import com.ssafyss.board_practice.global.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AuthExceptionHandler {

    @ExceptionHandler(DuplicatedEmailException.class)
    public ResponseEntity<?> handleDuplicatedEmailException(DuplicatedEmailException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ErrorResponse.Builder()
                        .message(e.getMessage())
                        .build());
    }

    @ExceptionHandler(SignInFailedException.class)
    public ResponseEntity<?> handleSignInFailedException(SignInFailedException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ErrorResponse.Builder()
                        .message(e.getMessage())
                        .build());
    }
}
