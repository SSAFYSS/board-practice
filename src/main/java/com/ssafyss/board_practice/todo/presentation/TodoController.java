package com.ssafyss.board_practice.todo.presentation;

import com.ssafyss.board_practice.todo.application.TodoService;
import com.ssafyss.board_practice.todo.application.dto.CreateTodoDto;
import com.ssafyss.board_practice.todo.application.dto.ReadTodoDetailDto;
import com.ssafyss.board_practice.todo.application.dto.ReadTodoDto;
import com.ssafyss.board_practice.todo.presentation.dto.request.CreateTodoRequest;
import com.ssafyss.board_practice.todo.presentation.dto.response.CreateTodoResponse;
import com.ssafyss.board_practice.todo.presentation.dto.response.ReadTodoResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping(value = "/todos")
    public ResponseEntity<List<ReadTodoResponse>> readAllTodo() {
        final List<ReadTodoDto> readAllTodos = todoService.readAllTodos();
        final List<ReadTodoResponse> response = readAllTodos.stream()
                                                            .map(ReadTodoResponse::new)
                                                            .toList();
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/todos")
    public ResponseEntity<CreateTodoResponse> createTodo(
            @RequestBody final CreateTodoRequest request
    ) {
        final CreateTodoDto createTodoDto = new CreateTodoDto(request);
        final ReadTodoDetailDto todo = todoService.createTodo(createTodoDto);
        final CreateTodoResponse response = new CreateTodoResponse(todo);

        return ResponseEntity.ok(response);
    }
}