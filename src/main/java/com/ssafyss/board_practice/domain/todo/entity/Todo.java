package com.ssafyss.board_practice.domain.todo.entity;

import java.sql.Timestamp;
import lombok.Builder;

@Builder
public class Todo {
    private Long id;
    private Long userId;
    private String content;
    private boolean completed;
    private Timestamp createdAt;
    private Timestamp deletedAt;
    private Timestamp updatedAt;
    private boolean deleted;
}
