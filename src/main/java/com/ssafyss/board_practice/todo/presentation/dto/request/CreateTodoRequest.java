package com.ssafyss.board_practice.todo.presentation.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateTodoRequest {

    private String content;

    public CreateTodoRequest() {
    }

    @JsonCreator
    public CreateTodoRequest(@JsonProperty String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
