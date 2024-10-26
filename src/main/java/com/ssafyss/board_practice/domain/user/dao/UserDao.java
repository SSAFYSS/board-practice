package com.ssafyss.board_practice.domain.user.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    int countEmail(String email);
}
