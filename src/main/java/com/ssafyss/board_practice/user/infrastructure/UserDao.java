package com.ssafyss.board_practice.user.infrastructure;

import com.ssafyss.board_practice.user.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    @Select("SELECT * FROM user WHERE email = #{email} ")
    public User searchByEmail(String email);
}
