package com.ssafyss.board_practice.todo.domain;

import java.time.LocalDateTime;

public class Todo {

    private Long id;
    private Long userId;
    private String content;
    private boolean completed;
    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;
    private LocalDateTime updatedAt;
    private boolean deleted;

    public Todo(Long userId, String content) {
        this.userId = userId;
        this.content = content;
        this.completed = false;
        this.deleted = false;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public boolean isDeleted() {
        return deleted;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", completed=" + completed +
                ", createdAt=" + createdAt +
                ", deletedAt=" + deletedAt +
                ", updatedAt=" + updatedAt +
                ", deleted=" + deleted +
                '}';
    }
}
