package com.ssafyss.board_practice.todo.presentation.dto.response;

import com.ssafyss.board_practice.todo.application.dto.ReadTodoDto;

public class ReadTodoResponse {
    private Long id;
    private String content;
    private boolean completed;

    public ReadTodoResponse(ReadTodoDto readTodoDto) {
        this.id = readTodoDto.getId();
        this.content = readTodoDto.getContent();
        this.completed = readTodoDto.isCompleted();
    }
}
