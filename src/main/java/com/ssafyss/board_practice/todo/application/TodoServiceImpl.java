package com.ssafyss.board_practice.todo.application;

import com.ssafyss.board_practice.global.message.ExceptionMessage;
import com.ssafyss.board_practice.todo.dto.CreateTodoRequest;
import com.ssafyss.board_practice.todo.dto.DeleteTodoRequest;
import com.ssafyss.board_practice.todo.dto.ReadTodoRequest;
import com.ssafyss.board_practice.todo.dto.UpdateTodoRequest;
import com.ssafyss.board_practice.todo.entity.Todo;
import com.ssafyss.board_practice.todo.exception.TodoNotFoundException;
import com.ssafyss.board_practice.todo.infrastructure.TodoRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    @Transactional
    public void createTodo(CreateTodoRequest request) {
        Todo todo = Todo.builder()
                .userId(request.getUserId())
                .content(request.getContent())
                .build();
        todoRepository.save(todo);
    }

    @Override
    public List<Todo> readTodos(ReadTodoRequest request) {
        return todoRepository.findByUserId(request.getUserId());
    }

    @Override
    @Transactional
    public void delete(DeleteTodoRequest request) {
        Todo todo = todoRepository.findById(request.getId())
                .orElseThrow(() -> new TodoNotFoundException(ExceptionMessage.NOT_FOUND_TODO.getMessage()));
        todo.delete();
    }

    @Override
    @Transactional
    public void updateContent(UpdateTodoRequest request) {
        Todo todo = todoRepository.findById(request.getId())
                .orElseThrow(() -> new TodoNotFoundException(ExceptionMessage.NOT_FOUND_TODO.getMessage()));
        todo.updateContent(request.getContent());
    }
}
