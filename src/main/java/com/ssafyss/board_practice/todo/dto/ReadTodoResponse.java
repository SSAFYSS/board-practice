package com.ssafyss.board_practice.todo.dto;

import com.ssafyss.board_practice.global.response.ResponseDto;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReadTodoResponse implements ResponseDto {
    List<ReadTodoDto> todos;
}
