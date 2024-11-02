package com.ssafyss.board_practice.todo.presentation;

import com.ssafyss.board_practice.todo.application.TodoService;
import com.ssafyss.board_practice.todo.application.dto.CreateTodoDto;
import com.ssafyss.board_practice.todo.application.dto.ReadTodoDto;
import com.ssafyss.board_practice.todo.presentation.dto.request.CreateRequest;
import com.ssafyss.board_practice.todo.presentation.dto.response.CreateResponse;
import com.ssafyss.board_practice.todo.presentation.dto.response.ReadResponse;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;
    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<List<ReadResponse>> readAllTodos(){
        List<ReadTodoDto> readTodos = todoService.readAllTodos();
        List<ReadResponse> result = readTodos.stream().map(ReadResponse::new).toList();

        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<CreateResponse> createTodo(@RequestBody CreateRequest createRequest){
        CreateTodoDto createTodoDto = new CreateTodoDto(createRequest);
        CreateResponse result = new CreateResponse(todoService.createTodo(createTodoDto));

        return ResponseEntity.ok(result);
    }

    @PatchMapping("/{todoId}")
    public ResponseEntity<ReadResponse> updateTodo(@PathVariable Long todoId){
        ReadTodoDto readTodo = todoService.updateTodo(todoId);
        ReadResponse result = new ReadResponse(readTodo);

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{todoID}")
    public ResponseEntity<ReadResponse> deleteTodo(@PathVariable Long todoId){
        ReadTodoDto readTodo = todoService.deleteTodo(todoId);
        ReadResponse result = new ReadResponse(readTodo);

        return ResponseEntity.ok(result);
    }

}
