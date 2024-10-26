package com.ssafyss.board_practice.todo.presentation.dto.response;

import com.ssafyss.board_practice.todo.application.dto.ReadTodoDetailDto;

public class CreateTodoResponse {
    private Long id;
    private String content;
    private boolean completed;

    public CreateTodoResponse(ReadTodoDetailDto readTodoDetailDto) {
        this.id = readTodoDetailDto.getId();
        this.content = readTodoDetailDto.getContent();
        this.completed = readTodoDetailDto.isCompleted();
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public boolean isCompleted() {
        return completed;
    }
}
