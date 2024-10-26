package com.ssafyss.board_practice.user.presentation;

import com.ssafyss.board_practice.user.application.UserLoginDto;
import com.ssafyss.board_practice.user.application.UserRegistDto;
import com.ssafyss.board_practice.user.application.UserService;
import com.ssafyss.board_practice.user.application.UserServiceImpl;
import com.ssafyss.board_practice.user.domain.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserServiceImpl userService){
        this.userService = userService;
    }

    @PostMapping("/regist")
    public ResponseEntity<String> regist(@RequestBody UserRegistDto userRegistDto){
        if(userService.regist(userRegistDto)){
            return ResponseEntity.ok("회원가입 성공!!!");
        }else{
            return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 등록된 이메일입니다!! 다른 이메일로 시도해주세요!!");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<LoginUserResponse> login(@RequestBody UserLoginDto userLoginDto, HttpSession session) {
        User user = userService.login(userLoginDto.getEmail());

        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginUserResponse(null, "로그인 하려는 아이디가 존재하지 않습니다!!"));
        }

        if (userService.checkPassword(userLoginDto.getPassword(), user.getPassword())) {
            session.setAttribute("userInfo", user);
            return ResponseEntity.ok(new LoginUserResponse(user,"로그인 성공!! 환영합니다!!"));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginUserResponse(null, "로그인 실패!! 비밀번호를 다시 확인 해주세요!!"));
        }
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session){
        session.invalidate();
        return ResponseEntity.ok("로그아웃 되었습니다!");
    }


}
