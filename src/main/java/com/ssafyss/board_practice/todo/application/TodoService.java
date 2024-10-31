package com.ssafyss.board_practice.todo.application;

import com.ssafyss.board_practice.todo.application.dto.CreateTodoDto;
import com.ssafyss.board_practice.todo.application.dto.ReadTodoDetailDto;
import com.ssafyss.board_practice.todo.application.dto.ReadTodoDto;
import com.ssafyss.board_practice.todo.domain.Todo;
import com.ssafyss.board_practice.todo.infrastructure.repository.TodoRepository;
import java.util.List;

import com.ssafyss.board_practice.user.domain.User;
import com.ssafyss.board_practice.user.infrastructure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<ReadTodoDto> readAllTodos() {
        final List<Todo> readTodos = todoRepository.findAllByDeletedFalse();
        return readTodos.stream().map(ReadTodoDto::new).toList();
    }

    public ReadTodoDetailDto createTodo(CreateTodoDto createTodoDto) {
        User user = userRepository.findById(createTodoDto.getUserId()).orElseThrow();
        Todo todo = new Todo(user, createTodoDto.getContent());
        todoRepository.save(todo);
        final Todo createdTodo = todoRepository.findById(todo.getId()).orElseThrow();
        return new ReadTodoDetailDto(createdTodo);
    }
}
