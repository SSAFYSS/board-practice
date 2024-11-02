package com.ssafyss.board_practice.todo.dto;

import com.ssafyss.board_practice.global.response.ResponseDto;
import java.sql.Timestamp;
import lombok.Getter;

@Getter
public class ReadTodoDto implements ResponseDto {
    private Long id;
    private Long userId;
    private String content;
    private boolean completed;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
