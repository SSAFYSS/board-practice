package com.ssafyss.board_practice.todo.application.dto;

import com.ssafyss.board_practice.todo.domain.Todo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class ReadTodoDto {
    private Long id;
    private Long userId;
    private String content;
    private boolean completed;
    private boolean deleted;

    public ReadTodoDto(Todo todo) {
        this.id = todo.getId();
        this.content = todo.getContent();
        this.completed = todo.isCompleted();
    }

    public ReadTodoDto(CreateTodoDto createTodoDto) {}
}
