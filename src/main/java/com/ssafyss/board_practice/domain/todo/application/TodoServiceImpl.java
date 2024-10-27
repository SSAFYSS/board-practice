package com.ssafyss.board_practice.domain.todo.application;

import com.ssafyss.board_practice.domain.todo.dao.TodoDao;
import com.ssafyss.board_practice.domain.todo.dto.CreateTodoRequest;
import com.ssafyss.board_practice.domain.todo.dto.DeleteTodoRequest;
import com.ssafyss.board_practice.domain.todo.dto.ReadTodoRequest;
import com.ssafyss.board_practice.domain.todo.dto.ReadTodoResponse;
import com.ssafyss.board_practice.domain.todo.dto.UpdateTodoRequest;
import com.ssafyss.board_practice.domain.todo.entity.Todo;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {

    private TodoDao todoDao;

    public TodoServiceImpl(TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    @Override
    public void createTodo(CreateTodoRequest request) {
        Todo todo = Todo.builder()
                .userId(request.getUserId())
                .content(request.getContent())
                .build();
        todoDao.insertTodo(todo);
    }

    @Override
    public List<ReadTodoResponse> readTodos(ReadTodoRequest request) {
        return todoDao.findTodosByUserId(request.getUserId());
    }

    @Override
    public void deleteTodo(DeleteTodoRequest request) {
        todoDao.deleteById(request.getId());
    }

    @Override
    public void updateTodo(UpdateTodoRequest request) {
        todoDao.updateTodo(request);
    }
}
