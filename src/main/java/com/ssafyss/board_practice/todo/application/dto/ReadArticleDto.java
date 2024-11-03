package com.ssafyss.board_practice.todo.application.dto;

import com.ssafyss.board_practice.todo.domain.Todo;
import java.time.LocalDateTime;
import java.util.List;

public record ReadArticleDto(
        int totalPage,
        List<ReadArticleInfo> articles
) {

    public static ReadArticleDto of(final List<Todo> todos, final int totalPages) {
        final List<ReadArticleInfo> readArticleInfos = todos.stream()
                                                            .map(ReadArticleInfo::from)
                                                            .toList();
        return new ReadArticleDto(
                totalPages,
                readArticleInfos
        );
    }

    public record ReadArticleInfo(
            Long id,
            String title,
            LocalDateTime createdAt
    ) {

        public static ReadArticleInfo from(final Todo todo) {
            return new ReadArticleInfo(
                    todo.getId(),
                    todo.getContent(),
                    todo.getCreatedAt()
            );
        }
    }
}
