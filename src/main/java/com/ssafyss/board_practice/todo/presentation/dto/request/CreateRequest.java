package com.ssafyss.board_practice.todo.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class CreateRequest {
    long userId;
    String content;
}
