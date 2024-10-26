package com.ssafyss.board_practice.todo.presentation.dto.request;

public class CreateTodoRequest {
    private String content;

    public CreateTodoRequest(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
