package com.ssafyss.board_practice.todo.application;

import com.ssafyss.board_practice.todo.application.dto.CreateTodoDto;
import com.ssafyss.board_practice.todo.application.dto.ReadTodoDto;
import java.util.List;

public interface TodoService {

    public List<ReadTodoDto> readAllTodos();
    public ReadTodoDto createTodo(CreateTodoDto createTodoDto);
    public ReadTodoDto updateTodo(Long id);
    public ReadTodoDto deleteTodo(Long id);

}
