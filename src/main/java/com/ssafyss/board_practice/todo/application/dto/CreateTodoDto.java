package com.ssafyss.board_practice.todo.application.dto;

import com.ssafyss.board_practice.todo.presentation.dto.request.CreateRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class CreateTodoDto {
    private long userId;
    private String content;

    public CreateTodoDto(CreateRequest createRequest){
        this.content = createRequest.getContent();
        this.userId = createRequest.getUserId();
    }
}
