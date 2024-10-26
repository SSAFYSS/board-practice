package com.ssafyss.board_practice.todo.domain;


public class Todo {
    private int id;
    private String userId;
    private String content;
    private boolean completed;
    private String createdAt;
    private String deletedAt;
    private String updateAt;
    private boolean delete;

    public Todo() {}
    public Todo(int id, String userId, String content, boolean completed, String createdAt, String deletedAt,
                String updateAt, boolean delete) {
        this.id = id;
        this.userId = userId;
        this.content = content;
        this.completed = completed;
        this.createdAt = createdAt;
        this.deletedAt = deletedAt;
        this.updateAt = updateAt;
        this.delete = delete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }
}
