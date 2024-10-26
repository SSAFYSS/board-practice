package com.ssafyss.board_practice.todo.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import com.ssafyss.board_practice.todo.application.dto.CreateTodoDto;
import com.ssafyss.board_practice.todo.application.dto.ReadTodoDto;
import com.ssafyss.board_practice.todo.domain.Todo;
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
        Todo todo = new Todo(3L, "노래 듣기");

        // when
        final CreateTodoDto actual = todoService.createTodo(todo);

        // then
        assertSoftly(softAssertions -> {
            assertThat(actual).isNotNull();
            assertThat(actual.getUserId()).isEqualTo(3L);
            assertThat(actual.getContent()).isEqualTo("노래 듣기");
        });
    }
}
