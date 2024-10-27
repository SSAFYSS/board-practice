package com.ssafyss.board_practice.domain.todo.api;

import com.ssafyss.board_practice.domain.todo.application.TodoService;
import com.ssafyss.board_practice.domain.todo.dto.CreateTodoRequest;
import com.ssafyss.board_practice.domain.todo.dto.ReadTodoRequest;
import com.ssafyss.board_practice.domain.todo.dto.ReadTodoResponse;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public void createTodo(@RequestBody CreateTodoRequest request) {
        todoService.createTodo(request);
    }

    @GetMapping
    public ResponseEntity<List<ReadTodoResponse>> readTodos(@RequestBody ReadTodoRequest request) {
        List<ReadTodoResponse> todos = todoService.readTodos(request);
        return ResponseEntity.ok(todos);
    }

}
