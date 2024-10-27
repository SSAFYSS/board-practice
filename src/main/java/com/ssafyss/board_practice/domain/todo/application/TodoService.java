package com.ssafyss.board_practice.domain.todo.application;

import com.ssafyss.board_practice.domain.todo.dto.CreateTodoRequest;
import com.ssafyss.board_practice.domain.todo.dto.DeleteTodoRequest;
import com.ssafyss.board_practice.domain.todo.dto.ReadTodoRequest;
import com.ssafyss.board_practice.domain.todo.dto.ReadTodoResponse;
import com.ssafyss.board_practice.domain.todo.dto.UpdateTodoRequest;
import java.util.List;

public interface TodoService {
    void createTodo(CreateTodoRequest request);

    List<ReadTodoResponse> readTodos(ReadTodoRequest request);

    void deleteTodo(DeleteTodoRequest request);

    void updateTodo(UpdateTodoRequest request);
}
