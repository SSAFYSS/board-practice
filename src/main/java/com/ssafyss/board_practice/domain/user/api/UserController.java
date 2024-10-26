package com.ssafyss.board_practice.domain.user.api;

import com.ssafyss.board_practice.domain.user.application.UserService;
import com.ssafyss.board_practice.domain.user.constants.SuccessMessages;
import com.ssafyss.board_practice.domain.user.dto.CheckEmailRequest;
import com.ssafyss.board_practice.global.dto.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/checkEmail")
    public ResponseEntity<BaseResponse> checkEmail(@RequestBody CheckEmailRequest request) {
        userService.checkEmail(request.getEmail());
        return ResponseEntity.ok(new BaseResponse.Builder()
                .message(SuccessMessages.EMAIL_AVAILABLE)
                .build());
    }

}
