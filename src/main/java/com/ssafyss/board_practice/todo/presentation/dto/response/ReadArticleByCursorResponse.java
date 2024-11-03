package com.ssafyss.board_practice.todo.presentation.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.ssafyss.board_practice.todo.application.dto.ReadArticleByCursorDto;
import com.ssafyss.board_practice.todo.application.dto.ReadArticleByCursorDto.ReadArticleInfo;
import java.time.LocalDateTime;
import java.util.List;

public record ReadArticleByCursorResponse(
        Long lastId,
        List<ArticleResponse> articles
) {

    public static ReadArticleByCursorResponse from(final ReadArticleByCursorDto readArticlesDto) {
        final List<ArticleResponse> articleResponses = readArticlesDto.articles()
                                                                      .stream()
                                                                      .map(ArticleResponse::from)
                                                                      .toList();
        return new ReadArticleByCursorResponse(
                readArticlesDto.cursorId(),
                articleResponses
        );
    }

    public record ArticleResponse(
            Long id,
            String title,
            @JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
            LocalDateTime createdAt
    ) {

        public static ArticleResponse from(final ReadArticleInfo readArticleInfo) {
            return new ArticleResponse(
                    readArticleInfo.id(),
                    readArticleInfo.title(),
                    readArticleInfo.createdAt()
            );
        }
    }
}
