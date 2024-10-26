package com.ssafyss.board_practice.user.application;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.ssafyss.board_practice.user.infrastructure.UserDao;
import com.ssafyss.board_practice.user.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserDao userDao;
    private final BCryptPasswordEncoder passwordEncoder;
    public UserServiceImpl(UserDao userDao){
        this.userDao = userDao;
        passwordEncoder = new BCryptPasswordEncoder();
    }

    public void register(User user) {
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

    }
    @Override
    public boolean checkPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    @Override
    public User login(String email) {
        return userDao.searchByEmail(email);
    }

    @Override
    public void logout() {

    }
}
