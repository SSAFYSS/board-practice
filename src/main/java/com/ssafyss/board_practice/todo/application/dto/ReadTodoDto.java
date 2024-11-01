package com.ssafyss.board_practice.todo.application.dto;

public record ReadTodoDto(
        Long id,
        Long userId,
        String content,
        boolean completed,
        boolean deleted
) {
}
