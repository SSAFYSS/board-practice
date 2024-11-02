package com.ssafyss.board_practice.todo.presentation;

import com.ssafyss.board_practice.global.message.SuccessMessage;
import com.ssafyss.board_practice.global.response.ApiResponse;
import com.ssafyss.board_practice.global.response.ResponseDto;
import com.ssafyss.board_practice.todo.application.TodoService;
import com.ssafyss.board_practice.todo.dto.CreateTodoRequest;
import com.ssafyss.board_practice.todo.dto.DeleteTodoRequest;
import com.ssafyss.board_practice.todo.dto.ReadTodoDto;
import com.ssafyss.board_practice.todo.dto.ReadTodoRequest;
import com.ssafyss.board_practice.todo.dto.ReadTodoResponse;
import com.ssafyss.board_practice.todo.dto.UpdateTodoRequest;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse createTodo(@RequestBody CreateTodoRequest request) {
        todoService.createTodo(request);

        return ApiResponse.builder()
                .message(SuccessMessage.SUCCESS_TODO_CREATE.getMessage())
                .build();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<ResponseDto> readTodos(@RequestBody ReadTodoRequest request) {
        List<ReadTodoDto> todos = todoService.readTodos(request);

        return ApiResponse.builder()
                .data(ReadTodoResponse.builder()
                        .todos(todos)
                        .build())
                .build();
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse deleteTodo(@RequestBody DeleteTodoRequest request) {
        todoService.deleteTodo(request);

        return ApiResponse.builder()
                .message(SuccessMessage.SUCCESS_TODO_DELETE.getMessage())
                .build();
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse updateTodo(@RequestBody UpdateTodoRequest request) {
        todoService.updateTodo(request);
        
        return ApiResponse.builder()
                .message(SuccessMessage.SUCCESS_TODO_UPDATE.getMessage())
                .build();
    }

}
