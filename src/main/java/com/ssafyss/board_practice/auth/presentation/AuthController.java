package com.ssafyss.board_practice.auth.presentation;

import com.ssafyss.board_practice.auth.application.AuthService;
import com.ssafyss.board_practice.auth.constants.SuccessMessages;
import com.ssafyss.board_practice.auth.dto.CheckEmailRequest;
import com.ssafyss.board_practice.auth.dto.CreateUserRequest;
import com.ssafyss.board_practice.auth.dto.SignInRequest;
import com.ssafyss.board_practice.auth.dto.SignInResponse;
import com.ssafyss.board_practice.global.dto.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/checkEmail")
    public ResponseEntity<BaseResponse> checkEmail(@RequestBody CheckEmailRequest request) {
        authService.checkEmail(request.getEmail());
        return ResponseEntity.ok(new BaseResponse.Builder()
                .message(SuccessMessages.EMAIL_AVAILABLE)
                .build());
    }

    @PostMapping("/signUp")
    public ResponseEntity<BaseResponse> signUp(@RequestBody CreateUserRequest request) {
        authService.signUp(request.getEmail(), request.getPassword());
        return ResponseEntity.ok(new BaseResponse.Builder()
                .message(SuccessMessages.SIGN_UP_SUCCESS)
                .build());
    }

    @PostMapping("/signIn")
    public ResponseEntity<SignInResponse> signIn(@RequestBody SignInRequest request) {
        SignInResponse signInResponse = authService.signIn(request.getEmail(), request.getPassword());
        return ResponseEntity.ok(signInResponse);
    }

}
