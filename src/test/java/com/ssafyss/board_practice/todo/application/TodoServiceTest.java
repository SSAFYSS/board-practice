package com.ssafyss.board_practice.todo.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import com.ssafyss.board_practice.todo.application.dto.CreateTodoDto;
import com.ssafyss.board_practice.todo.application.dto.ReadTodoDetailDto;
import com.ssafyss.board_practice.todo.application.dto.ReadTodoDto;
import com.ssafyss.board_practice.todo.domain.Todo;
import com.ssafyss.board_practice.todo.infrastructure.repository.TodoRepository;
import com.ssafyss.board_practice.todo.presentation.dto.request.CreateTodoRequest;
import com.ssafyss.board_practice.user.domain.User;
import com.ssafyss.board_practice.user.infrastructure.repository.UserRepository;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class TodoServiceTest {

    @Autowired
    private TodoService todoService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TodoRepository todoRepository;

    final User user = User.builder()
                          .email("abc@abc.com")
                          .name("abc")
                          .password("abc")
                          .build();
    User user2 = User.builder()
                     .email("abc2@abc.com")
                     .name("abc2")
                     .password("abc2")
                     .build();
    Todo todo1 = Todo.builder()
                     .user(user)
                     .content("7시에 일어나기")
                     .build();
    Todo todo2 = Todo.builder()
                     .user(user)
                     .content("알고리즘 풀기")
                     .build();
    Todo todo3 = Todo.builder()
                     .user(user2)
                     .content("알고리즘 풀기")
                     .build();

    @BeforeEach
    void init() {
        userRepository.saveAll(List.of(user, user2));
        todoRepository.saveAll(List.of(todo1, todo2, todo3));
    }

    @Test
    void 모든_todo를_조회한다() {
        // when
        final List<ReadTodoDto> actual = todoService.readAllTodos();

        // then
        ReadTodoDto actualDto = actual.get(0);
        assertSoftly(softAssertions -> {
            assertThat(actual).isNotNull();
            assertThat(actual.size()).isEqualTo(3);
            // 리스트의 첫번째에 해당하는 객체만 검증
            assertThat(actualDto.id()).isEqualTo(todo1.getId());
            assertThat(actualDto.userId()).isEqualTo(todo1.getUser().getId());
            assertThat(actualDto.content()).isEqualTo(todo1.getContent());
            assertThat(actualDto.completed()).isEqualTo(todo1.isCompleted());
            assertThat(actualDto.deleted()).isEqualTo(todo1.isDeleted());
        });
    }

    @Test
    void todo를_생성한다() {
        // given
        final CreateTodoRequest createTodoRequest = new CreateTodoRequest("밥 먹기");
        final CreateTodoDto createTodoDto = CreateTodoDto.of(user.getId(), createTodoRequest);

        // when
        final ReadTodoDetailDto actual = todoService.createTodo(createTodoDto);

        // then
        assertSoftly(softAssertions -> {
            assertThat(actual).isNotNull();
            assertThat(actual.userId()).isEqualTo(user.getId());
            assertThat(actual.content()).isEqualTo(createTodoRequest.content());
        });
    }
}
