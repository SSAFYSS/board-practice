package com.ssafyss.board_practice.todo.presentation.dto.response;

import com.ssafyss.board_practice.todo.application.dto.ReadTodoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class CreateResponse {
    private Long id;
    private String content;
    private boolean completed;

    public CreateResponse(ReadTodoDto todo) {}
}
