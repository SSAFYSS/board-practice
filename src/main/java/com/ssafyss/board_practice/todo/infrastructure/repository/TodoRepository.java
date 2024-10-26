package com.ssafyss.board_practice.todo.infrastructure.repository;

import com.ssafyss.board_practice.todo.domain.Todo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TodoRepository {
    List<Todo> findAllTodo();

    void createTodo(Todo todo);

    Todo findById(Long id);
}
