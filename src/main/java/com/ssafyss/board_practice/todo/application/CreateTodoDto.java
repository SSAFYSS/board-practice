package com.ssafyss.board_practice.todo.application;

public class CreateTodoDto {
    private long id;
    private String userId;
    private String content;

    public CreateTodoDto(long id,String userId, String content) {
        this.id = id;
        this.userId = userId;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}
