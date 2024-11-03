package com.ssafyss.board_practice.todo.presentation;

import com.ssafyss.board_practice.todo.application.TodoService;
import com.ssafyss.board_practice.todo.presentation.dto.response.ReadArticleResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
public class PagingController {

    private static final Logger log = LoggerFactory.getLogger(TodoController.class);

    private TodoService todoService;

    @Autowired
    public PagingController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping(value = "/paging/offset")
    public ResponseEntity<ReadArticleResponse> readByOffset() {

        return ResponseEntity.ok().build();
    }
}
