package com.ssafyss.board_practice.todo.presentation.dto.response;

import com.ssafyss.board_practice.todo.application.dto.ReadTodoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class ReadResponse {
    Long id;
    String content;
    boolean completed;

    public ReadResponse(ReadTodoDto todo) {
        this.id = todo.getId();
        this.content = todo.getContent();
        this.completed = todo.isCompleted();
    }
}
