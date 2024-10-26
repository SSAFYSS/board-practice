package com.ssafyss.board_practice.todo.presentation.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ssafyss.board_practice.todo.application.dto.ReadTodoDto;

public class ReadTodoResponse {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("content")
    private String content;

    @JsonProperty("completed")
    private boolean completed;

    public ReadTodoResponse(ReadTodoDto readTodoDto) {
        this.id = readTodoDto.getId();
        this.content = readTodoDto.getContent();
        this.completed = readTodoDto.isCompleted();
    }
}
