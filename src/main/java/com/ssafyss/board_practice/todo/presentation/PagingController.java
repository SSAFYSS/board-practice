package com.ssafyss.board_practice.todo.presentation;

import com.ssafyss.board_practice.todo.application.TodoService;
import com.ssafyss.board_practice.todo.application.dto.ReadArticleByCursorDto;
import com.ssafyss.board_practice.todo.application.dto.ReadArticleDto;
import com.ssafyss.board_practice.todo.presentation.dto.response.ReadArticleByCursorResponse;
import com.ssafyss.board_practice.todo.presentation.dto.response.ReadArticleResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<ReadArticleResponse> readByOffset(
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "0") int page
    ) {
        final Pageable pageable = PageRequest.of(page, size);
        final ReadArticleDto readArticleDto = todoService.readAllTodosByPagingOffset(pageable);
        final ReadArticleResponse response = ReadArticleResponse.from(readArticleDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/paging/cursor")
    public ResponseEntity<ReadArticleByCursorResponse> readByCursor(
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) Long cursorId
    ) {
        final Pageable pageable = PageRequest.of(0, size);
        final ReadArticleByCursorDto readArticlesDto = todoService.readAllTodosByPagingCursor(
                cursorId, pageable);
        final ReadArticleByCursorResponse response = ReadArticleByCursorResponse.from(
                readArticlesDto);
        return ResponseEntity.ok(response);
    }
}