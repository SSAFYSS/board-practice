package com.ssafyss.board_practice.todo.presentation.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.ssafyss.board_practice.todo.application.dto.ReadArticleDto;
import com.ssafyss.board_practice.todo.application.dto.ReadArticleDto.ReadArticleInfo;
import java.time.LocalDateTime;
import java.util.List;

public record ReadArticleResponse(
        int totalPage,
        List<ArticleResponse> articles
) {

    public static ReadArticleResponse from(final ReadArticleDto readArticleDto) {
        final List<ArticleResponse> articleResponses = readArticleDto.articles()
                                                                     .stream()
                                                                     .map(ArticleResponse::from)
                                                                     .toList();
        return new ReadArticleResponse(
                readArticleDto.totalPage(),
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
