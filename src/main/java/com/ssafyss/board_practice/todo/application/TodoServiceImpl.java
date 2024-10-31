package com.ssafyss.board_practice.todo.application;

import com.ssafyss.board_practice.todo.dto.CreateTodoRequest;
import com.ssafyss.board_practice.todo.dto.DeleteTodoRequest;
import com.ssafyss.board_practice.todo.dto.ReadTodoRequest;
import com.ssafyss.board_practice.todo.dto.ReadTodoResponse;
import com.ssafyss.board_practice.todo.dto.UpdateTodoRequest;
import com.ssafyss.board_practice.todo.entity.Todo;
import com.ssafyss.board_practice.todo.infrastructure.TodoRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public void createTodo(CreateTodoRequest request) {
        Todo todo = Todo.builder()
                .userId(request.getUserId())
                .content(request.getContent())
                .build();
        todoRepository.insert(todo);
    }

    @Override
    public List<ReadTodoResponse> readTodos(ReadTodoRequest request) {
        return todoRepository.findByUserId(request.getUserId());
    }

    @Override
    public void deleteTodo(DeleteTodoRequest request) {
        todoRepository.deleteById(request.getId());
    }

    @Override
    public void updateTodo(UpdateTodoRequest request) {
        todoRepository.update(request);
    }
}
