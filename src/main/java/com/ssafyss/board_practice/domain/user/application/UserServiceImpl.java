package com.ssafyss.board_practice.domain.user.application;

import com.ssafyss.board_practice.domain.user.constants.ErrorMessages;
import com.ssafyss.board_practice.domain.user.dao.UserDao;
import com.ssafyss.board_practice.domain.user.exception.DuplicatedEmailException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final PasswordEncoder encoder;

    public UserServiceImpl(UserDao userDao, PasswordEncoder encoder) {
        this.userDao = userDao;
        this.encoder = encoder;
    }

    @Override
    public void checkEmail(String email) {
        int count = userDao.countEmail(email);
        if (count >= 1) {
            throw new DuplicatedEmailException(ErrorMessages.EMAIL_DUPLICATED);
        }
    }

    @Override
    public void signUp(String email, String password) {
        checkEmail(email);
        userDao.insertUser(email, encoder.encode(password));
    }
}
