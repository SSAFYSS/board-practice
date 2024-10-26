package com.ssafyss.board_practice.todo.application;

import com.ssafyss.board_practice.todo.application.dto.CreateTodoDto;
import com.ssafyss.board_practice.todo.application.dto.ReadTodoDto;
import com.ssafyss.board_practice.todo.domain.Todo;
import com.ssafyss.board_practice.todo.infrastructure.repository.TodoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Transactional(readOnly = true)
    public List<ReadTodoDto> readAllTodos() {
        final List<Todo> readTodos = todoRepository.findAllTodo();
        return readTodos.stream().map(ReadTodoDto::new).toList();
    }

    public CreateTodoDto createTodo(Todo todo) {
        todoRepository.createTodo(todo);
        final Todo createdTodo = todoRepository.findById(todo.getId());
        return new CreateTodoDto(createdTodo);
    }
}
