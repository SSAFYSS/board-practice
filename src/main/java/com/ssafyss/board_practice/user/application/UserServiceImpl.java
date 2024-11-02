package com.ssafyss.board_practice.user.application;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.ssafyss.board_practice.user.infrastructure.UserRepository;
import com.ssafyss.board_practice.user.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{


    @Override
    public User login(String email) {
        return null;
    }

    @Override
    public boolean checkPassword(String rawPassword, String encodedPassword) {
        return false;
    }

    @Override
    public boolean regist(UserRegistDto user) {
        return false;
    }

    @Override
    public boolean delete(String email) {
        return false;
    }
}
