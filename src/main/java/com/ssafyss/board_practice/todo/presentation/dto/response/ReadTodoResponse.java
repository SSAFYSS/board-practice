package com.ssafyss.board_practice.todo.presentation.dto.response;

import com.ssafyss.board_practice.global.response.ResponseDto;

public record ReadTodoResponse(
        Long id,
        String content,
        boolean completed
) implements ResponseDto {
}
