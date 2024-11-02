package com.ssafyss.board_practice.todo.presentation.dto.response;

import com.ssafyss.board_practice.global.response.ResponseDto;
import com.ssafyss.board_practice.todo.application.dto.ReadTodoDto;

public record ReadTodoResponse(
        Long id,
        String content,
        boolean completed
) implements ResponseDto {

    public static ReadTodoResponse of(final ReadTodoDto dto) {
        return new ReadTodoResponse(
                dto.id(),
                dto.content(),
                dto.completed()
        );
    }
}
