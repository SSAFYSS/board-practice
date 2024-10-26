package com.ssafyss.board_practice.domain.user.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    @DisplayName("회원 삽입 확인하는 테스트")
    void insertUserTest() {
        // given
        String email = "test@example.com";
        userDao.insertUser(email, "password123");
        // when
        int count = userDao.countEmail(email);
        // then
        assertThat(count).isEqualTo(1);
    }

    @Test
    @DisplayName("존재하지 않는 이메일일 경우 0을 반환한다")
    void returnZeroWhenNotDuplicatedEmail() {
        // given
        String email = "NOT_EXIST_EMAIL";
        // when
        int count = userDao.countEmail(email);
        // then
        assertThat(count).isEqualTo(0);
    }

}
