package com.ssafyss.board_practice.domain.user.dao;

import com.ssafyss.board_practice.domain.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    int countByEmail(String email);

    void insert(User user);

    User findByEmail(String email);
}
