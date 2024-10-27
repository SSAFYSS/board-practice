package com.ssafyss.board_practice.domain.todo.dto;

import lombok.Getter;

@Getter
public class CreateTodoRequest {
    private Long userId;
    private String content;
}
