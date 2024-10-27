package com.ssafyss.board_practice.domain.todo.dto;

import lombok.Getter;

@Getter
public class UpdateTodoRequest {
    private Long id;
    private String content;
}
