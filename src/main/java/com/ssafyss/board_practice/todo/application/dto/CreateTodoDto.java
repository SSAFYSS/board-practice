package com.ssafyss.board_practice.todo.application.dto;

import com.ssafyss.board_practice.todo.domain.Todo;

// TODO 24.10.26 DTO 이름 규칙 및 타입에 대해 논의하고 싶습니다.
public class CreateTodoDto {
    private Long id;
    private Long userId;
    private String content;
    private boolean completed;
    private boolean deleted;

    public CreateTodoDto(Todo todo) {
        this.id = todo.getId();
        this.userId = todo.getUserId();
        this.content = todo.getContent();
        this.completed = todo.isCompleted();
        this.deleted = todo.isDeleted();
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public String getContent() {
        return content;
    }

    public boolean isCompleted() {
        return completed;
    }

    public boolean isDeleted() {
        return deleted;
    }
}
