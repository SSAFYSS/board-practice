package com.ssafyss.board_practice.todo.application.dto;

public record CreateTodoDto(
        Long userId,
        String content
) {
}
