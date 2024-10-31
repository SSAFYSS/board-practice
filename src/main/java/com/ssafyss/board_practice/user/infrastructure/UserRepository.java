package com.ssafyss.board_practice.user.infrastructure;

import com.ssafyss.board_practice.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
    int countByEmail(String email);

    void insert(User user);

    User findByEmail(String email);
}
