package com.ssafyss.board_practice.todo.application;

import com.ssafyss.board_practice.todo.dto.CreateTodoRequest;
import com.ssafyss.board_practice.todo.dto.DeleteTodoRequest;
import com.ssafyss.board_practice.todo.dto.ReadTodoRequest;
import com.ssafyss.board_practice.todo.dto.UpdateTodoRequest;
import com.ssafyss.board_practice.todo.entity.Todo;
import java.util.List;

public interface TodoService {
    void createTodo(CreateTodoRequest request);

    List<Todo> readTodos(ReadTodoRequest request);

    void delete(DeleteTodoRequest request);

    void updateContent(UpdateTodoRequest request);
}
