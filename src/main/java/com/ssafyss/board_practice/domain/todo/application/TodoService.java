package com.ssafyss.board_practice.domain.todo.application;

import com.ssafyss.board_practice.domain.todo.dto.CreateTodoRequest;
import com.ssafyss.board_practice.domain.todo.dto.ReadTodoRequest;
import com.ssafyss.board_practice.domain.todo.dto.ReadTodoResponse;
import java.util.List;

public interface TodoService {
    void createTodo(CreateTodoRequest request);

    List<ReadTodoResponse> readTodos(ReadTodoRequest request);
}
