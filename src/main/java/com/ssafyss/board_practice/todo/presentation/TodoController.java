package com.ssafyss.board_practice.todo.presentation;

import com.ssafyss.board_practice.todo.application.CreateTodoDto;
import com.ssafyss.board_practice.todo.application.TodoService;
import com.ssafyss.board_practice.todo.application.UpdateTodoDto;
import com.ssafyss.board_practice.todo.domain.Todo;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity<?> insert(@RequestBody CreateTodoDto cDto) {
        int result = todoService.insert(cDto);

        if (result > 0) {
            return ResponseEntity.status(HttpStatus.CREATED).body("추가 성공!!");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("추가 실패");
        }
    }

    @GetMapping
    public ResponseEntity getList() {
        List<Todo> todos = todoService.searchAll();
        return ResponseEntity.ok(todos);
    }

    @PatchMapping("/{Id}")
    public ResponseEntity<Void> updateTodo(
            @PathVariable int Id,
            @RequestBody UpdateTodoDto updateTodoDto) {

        updateTodoDto.setId(Id);

        int updatedCount = todoService.update(updateTodoDto);

        if (updatedCount > 0) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable int Id) {
        int deletedCount = todoService.delete(Id);

        if (deletedCount > 0) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> options() {
        return ResponseEntity.ok().build();
    }

}
