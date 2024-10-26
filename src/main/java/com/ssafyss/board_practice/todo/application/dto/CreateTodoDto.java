package com.ssafyss.board_practice.todo.application.dto;

import com.ssafyss.board_practice.todo.presentation.dto.request.CreateTodoRequest;

public class CreateTodoDto {
    private Long userId;
    private String content;

    public CreateTodoDto(CreateTodoRequest request) {
        this.userId = 3L; // TODO: 임시로 3L로 지정, 로그인 기능 구현 후 수정
        this.content = request.getContent();
    }

    public Long getUserId() {
        return userId;
    }

    public String getContent() {
        return content;
    }
}
