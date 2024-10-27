package com.ssafyss.board_practice.domain.todo.application;

import com.ssafyss.board_practice.domain.todo.dto.CreateTodoRequest;

public interface TodoService {
    void createTodo(CreateTodoRequest request);
}
