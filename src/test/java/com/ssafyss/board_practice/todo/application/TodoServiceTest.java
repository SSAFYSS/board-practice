package com.ssafyss.board_practice.todo.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import com.ssafyss.board_practice.todo.application.dto.CreateTodoDto;
import com.ssafyss.board_practice.todo.application.dto.ReadTodoDetailDto;
import com.ssafyss.board_practice.todo.application.dto.ReadTodoDto;
import com.ssafyss.board_practice.todo.presentation.dto.request.CreateTodoRequest;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TodoServiceTest {

    @Autowired
    private TodoService todoService;

    @Test
    void 모든_todo를_조회한다() {
        // when
        final List<ReadTodoDto> actual = todoService.readAllTodos();

        // then
        assertThat(actual).isNotNull();
    }

    @Test
    void todo를_생성한다() {
        // given
        CreateTodoDto createTodoDto = new CreateTodoDto(new CreateTodoRequest("밥 먹기"));

        // when
        final ReadTodoDetailDto actual = todoService.createTodo(createTodoDto);

        // then
        assertSoftly(softAssertions -> {
            assertThat(actual).isNotNull();
            assertThat(actual.getUserId()).isEqualTo(3L);
            assertThat(actual.getContent()).isEqualTo("밥 먹기");
        });
    }
}
