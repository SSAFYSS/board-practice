package com.ssafyss.board_practice.todo.presentation;

import com.ssafyss.board_practice.todo.application.CreateTodoDto;
import com.ssafyss.board_practice.todo.application.TodoService;
import com.ssafyss.board_practice.todo.domain.Todo;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos")
@CrossOrigin(origins = "https://ssafysandbox.vercel.app")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity insert(@RequestBody CreateTodoDto cDto) {
        Todo createdTodo = todoService.insert(cDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTodo);
    }

    @GetMapping
    public ResponseEntity getList() {
        List<Todo> todos = todoService.searchAll();
        return ResponseEntity.ok(todos);
    }

    @RequestMapping(method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> options() {
        return ResponseEntity.ok().build();
    }

}
