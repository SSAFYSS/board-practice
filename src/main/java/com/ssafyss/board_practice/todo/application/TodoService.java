package com.ssafyss.board_practice.todo.application;

import com.ssafyss.board_practice.todo.domain.Todo;
import java.util.List;

public interface TodoService {

    public Todo insert(Todo todo);

    public List<Todo> searchAll();

}
