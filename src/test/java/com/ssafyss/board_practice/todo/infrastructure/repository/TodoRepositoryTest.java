package com.ssafyss.board_practice.todo.infrastructure.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.ssafyss.board_practice.todo.domain.Todo;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TodoRepositoryTest {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    void 모든_todo를_조회한다() {
        // when
        List<Todo> actual = todoRepository.findAllTodo();

        // then
        assertThat(actual).isNotNull();
    }

    @Test
    void todo를_생성한다() {
        // given
        Todo todo = new Todo(3L, "7시에 일어나기");

        // when
        todoRepository.createTodo(todo);
        Long actual = todo.getId();
        System.out.println(actual);

        // then
        assertThat(actual).isNotNull();
    }
}
