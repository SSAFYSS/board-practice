package com.ssafyss.board_practice.todo.application;

import com.ssafyss.board_practice.todo.application.dto.CreateTodoDto;
import com.ssafyss.board_practice.todo.application.dto.ReadTodoDto;
import com.ssafyss.board_practice.todo.domain.Todo;
import com.ssafyss.board_practice.todo.infrastructure.TodoRepository;
import com.ssafyss.board_practice.user.domain.User;
import com.ssafyss.board_practice.user.infrastructure.UserRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;
    public TodoServiceImpl(TodoRepository  todoRepository, UserRepository userRepository) {
        this.todoRepository = todoRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<ReadTodoDto> readAllTodos() {
        List<Todo> readTodos = todoRepository.findAllByDeletedFalse();
        List<ReadTodoDto> todos = readTodos.stream().map(ReadTodoDto::new).toList();
        return todos;
    }

    @Override
    public ReadTodoDto createTodo(CreateTodoDto createTodoDto) {
        User user = userRepository.findById(createTodoDto.getUserId()).orElseThrow();
        Todo todo = new Todo(user, createTodoDto.getContent());
        todoRepository.save(todo);
        Todo createDto = todoRepository.findById(todo.getId()).orElseThrow();
        ReadTodoDto result = new ReadTodoDto(createDto);
        return result;
    }

    @Override
    public ReadTodoDto updateTodo(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow();
        todo.toggleCompleted();
        todoRepository.save(todo);
        Todo updateDto = todoRepository.findById(todo.getId()).orElseThrow();
        ReadTodoDto result = new ReadTodoDto(updateDto);
        return result;
    }

    @Override
    public ReadTodoDto deleteTodo(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow();
        todo.toggleDelete();
        todoRepository.save(todo);
        Todo updateDto = todoRepository.findById(todo.getId()).orElseThrow();
        ReadTodoDto result = new ReadTodoDto(updateDto);
        return result;
    }
}
