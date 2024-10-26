package com.ssafyss.board_practice.todo.application;

import com.ssafyss.board_practice.todo.domain.Todo;
import java.util.List;

public interface TodoService {

    public Todo insert(CreateTodoDto cDto);

    public List<Todo> searchAll();

}
