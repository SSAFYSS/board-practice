package com.ssafyss.board_practice.domain.todo.dto;

import java.sql.Timestamp;
import lombok.Getter;

@Getter
public class ReadTodoResponse {
    private Long id;
    private Long userId;
    private String content;
    private boolean completed;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
