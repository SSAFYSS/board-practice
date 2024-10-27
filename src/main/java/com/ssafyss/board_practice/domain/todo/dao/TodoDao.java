package com.ssafyss.board_practice.domain.todo.dao;

import com.ssafyss.board_practice.domain.todo.dto.ReadTodoResponse;
import com.ssafyss.board_practice.domain.todo.dto.UpdateTodoRequest;
import com.ssafyss.board_practice.domain.todo.entity.Todo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TodoDao {
    void insertTodo(Todo todo);

    List<ReadTodoResponse> findTodosByUserId(Long userId);

    int deleteById(Long id);

    void updateTodo(UpdateTodoRequest request);
}
