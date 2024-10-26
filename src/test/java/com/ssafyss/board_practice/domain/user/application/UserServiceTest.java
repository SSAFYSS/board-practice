package com.ssafyss.board_practice.domain.user.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.ssafyss.board_practice.domain.user.constants.ErrorMessages;
import com.ssafyss.board_practice.domain.user.dao.UserDao;
import com.ssafyss.board_practice.domain.user.exception.DuplicatedEmailException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class UserServiceTest {

    private UserDao userDao;
    private PasswordEncoder encoder;
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        userDao = mock(UserDao.class);
        encoder = mock(PasswordEncoder.class);
        userService = new UserServiceImpl(userDao, encoder);
    }

    @Test
    @DisplayName("이메일 중복확인 테스트 : 중복된 이메일이 있을 땐 예외를 반환한다")
    public void checkEmailDuplicatedEmailTest() {
        // given
        String email = "DUPLICATED_EMAIL";
        when(userDao.countEmail(email)).thenReturn(1); // 중복된 이메일이 있다고 설정

        // when, then
        DuplicatedEmailException thrown =
                assertThrows(DuplicatedEmailException.class, () -> userService.checkEmail(email));

        // then
        assertEquals(ErrorMessages.EMAIL_DUPLICATED, thrown.getMessage());
    }

    @Test
    @DisplayName("회원가입 성공 테스트")
    public void signUpSuccessTest() {
        // given
        String email = "NOT_EXIST_EMAIL";
        String password = "password123";
        when(userDao.countEmail(email)).thenReturn(0);
        when(encoder.encode(password)).thenReturn("hashedPassword");

        // when
        userService.signUp(email, password);

        // then
        verify(userDao).insertUser(email, "hashedPassword");
    }

    @Test
    @DisplayName("회원가입 테스트 : 중복된 이메일이 있을 땐 예외를 반환한다")
    public void testSignUpDuplicatedEmail() {
        // given
        String email = "DUPLICATED_EMAIL";
        String password = "password123";
        when(userDao.countEmail(email)).thenReturn(1);

        // when, then
        DuplicatedEmailException thrown =
                assertThrows(DuplicatedEmailException.class, () -> userService.signUp(email, password));

        // then
        assertEquals(ErrorMessages.EMAIL_DUPLICATED, thrown.getMessage());
    }

}
