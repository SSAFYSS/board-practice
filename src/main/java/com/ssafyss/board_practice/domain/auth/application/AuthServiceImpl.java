package com.ssafyss.board_practice.domain.auth.application;

import com.ssafyss.board_practice.domain.auth.constants.ErrorMessages;
import com.ssafyss.board_practice.domain.auth.dto.SignInResponse;
import com.ssafyss.board_practice.domain.auth.exception.DuplicatedEmailException;
import com.ssafyss.board_practice.domain.auth.exception.SignInFailedException;
import com.ssafyss.board_practice.domain.user.dao.UserDao;
import com.ssafyss.board_practice.domain.user.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserDao userDao;
    private final PasswordEncoder encoder;

    public AuthServiceImpl(UserDao userDao, PasswordEncoder encoder) {
        this.userDao = userDao;
        this.encoder = encoder;
    }

    @Override
    public void checkEmail(String email) {
        int count = userDao.countByEmail(email);
        if (count >= 1) {
            throw new DuplicatedEmailException(ErrorMessages.EMAIL_DUPLICATED);
        }
    }

    @Override
    public void signUp(String email, String password) {
        checkEmail(email);
        User user = User.builder()
                .email(email)
                .password(password)
                .build();
        userDao.insert(user);
    }

    @Override
    public SignInResponse signIn(String email, String password) {
        User user = userDao.findByEmail(email);
        if (user == null || !encoder.matches(password, user.getPassword())) {
            throw new SignInFailedException(ErrorMessages.SIGN_IN_FAILED);
        }
        return new SignInResponse.Builder()
                .id(user.getId())
                .build();
    }
}
