package com.ssafyss.board_practice.todo.presentation;

import com.ssafyss.board_practice.global.dto.BaseResponse;
import com.ssafyss.board_practice.todo.application.TodoService;
import com.ssafyss.board_practice.todo.dto.CreateTodoRequest;
import com.ssafyss.board_practice.todo.dto.DeleteTodoRequest;
import com.ssafyss.board_practice.todo.dto.ReadTodoRequest;
import com.ssafyss.board_practice.todo.dto.ReadTodoResponse;
import com.ssafyss.board_practice.todo.dto.UpdateTodoRequest;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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

    @DeleteMapping
    public ResponseEntity<Void> deleteTodo(@RequestBody DeleteTodoRequest request) {
        todoService.deleteTodo(request);
        return ResponseEntity.ok().build();
    }

    @PatchMapping
    public ResponseEntity<BaseResponse> updateTodo(@RequestBody UpdateTodoRequest request) {
        todoService.updateTodo(request);
        return ResponseEntity.ok(new BaseResponse.Builder()
                .message("수정되었습니다")
                .build());
    }

}
