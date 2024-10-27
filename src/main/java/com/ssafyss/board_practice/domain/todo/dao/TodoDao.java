package com.ssafyss.board_practice.domain.todo.dao;

import com.ssafyss.board_practice.domain.todo.entity.Todo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TodoDao {
    void insertTodo(Todo todo);
}
