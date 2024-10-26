package com.ssafyss.board_practice.domain.user.application;

import com.ssafyss.board_practice.domain.user.constants.ErrorMessages;
import com.ssafyss.board_practice.domain.user.dao.UserDao;
import com.ssafyss.board_practice.domain.user.exception.DuplicatedEmailException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void checkEmail(String email) {
        int count = userDao.countEmail(email);
        if (count >= 1) {
            throw new DuplicatedEmailException(ErrorMessages.EMAIL_DUPLICATED);
        }
    }
}
