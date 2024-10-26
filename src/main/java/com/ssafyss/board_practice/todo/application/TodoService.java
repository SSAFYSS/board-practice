package com.ssafyss.board_practice.todo.application;

import com.ssafyss.board_practice.todo.domain.Todo;
import java.util.List;

public interface TodoService {

    public int insert(CreateTodoDto cDto);

    public List<Todo> searchAll();

    public int update(UpdateTodoDto uDto);

    public int delete(int id);

}
