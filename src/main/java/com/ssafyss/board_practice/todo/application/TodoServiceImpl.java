package com.ssafyss.board_practice.todo.application;

import com.ssafyss.board_practice.todo.domain.Todo;
import com.ssafyss.board_practice.todo.infrastructure.TodoDao;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoDao todoDao;

    public TodoServiceImpl(TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    @Override
    public int insert(CreateTodoDto cDto) {
        return todoDao.insert(cDto);
    }

    @Override
    public List<Todo> searchAll() {
        return todoDao.searchAll();
    }

    @Override
    public int update(UpdateTodoDto uDto) {
        return todoDao.update(uDto);
    }

    @Override
    public int delete(int id) {
        return todoDao.delete(id);
    }

}
