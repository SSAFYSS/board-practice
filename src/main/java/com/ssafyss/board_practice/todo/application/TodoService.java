package com.ssafyss.board_practice.todo.application;

import com.ssafyss.board_practice.todo.application.dto.CreateTodoDto;
import com.ssafyss.board_practice.todo.application.dto.ReadArticleByCursorDto;
import com.ssafyss.board_practice.todo.application.dto.ReadArticleDto;
import com.ssafyss.board_practice.todo.application.dto.ReadTodoDetailDto;
import com.ssafyss.board_practice.todo.application.dto.ReadTodoDto;
import com.ssafyss.board_practice.todo.application.exception.ForbiddenUserToUpdateTodoException;
import com.ssafyss.board_practice.todo.application.exception.NotFoundTodoException;
import com.ssafyss.board_practice.todo.domain.Todo;
import com.ssafyss.board_practice.todo.infrastructure.repository.TodoRepository;
import com.ssafyss.board_practice.user.application.exception.NotFoundUserException;
import com.ssafyss.board_practice.user.domain.User;
import com.ssafyss.board_practice.user.infrastructure.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TodoService {

    private TodoRepository todoRepository;
    private UserRepository userRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository, UserRepository userRepository) {
        this.todoRepository = todoRepository;
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List<ReadTodoDto> readAllTodos(final Long userId) {
        isValidUser(userId);
        final List<Todo> readTodos = todoRepository.findAllByUserIdAndDeletedFalse(userId);
        return readTodos.stream()
                        .map(ReadTodoDto::of)
                        .toList();
    }

    private User isValidUser(final Long userId) {
        return userRepository.findById(userId)
                             .orElseThrow(NotFoundUserException::new);
    }

    public ReadTodoDetailDto createTodo(final CreateTodoDto createTodoDto) {
        final User user = isValidUser(createTodoDto.userId());
        final Long todoId = saveTodo(user, createTodoDto.content());
        final Todo createdTodo = todoRepository.findById(todoId)
                                               .orElseThrow(NotFoundTodoException::new);
        return ReadTodoDetailDto.from(createdTodo);
    }

    private Long saveTodo(final User user, final String content) {
        final Todo todo = Todo.builder()
                              .user(user)
                              .content(content)
                              .build();
        final Todo savedTodo = todoRepository.save(todo);
        return savedTodo.getId();
    }

    public void updateTodo(final Long userId, final Long todoId) {
        isValidUser(userId);
        final Todo todo = todoRepository.findById(todoId).orElseThrow(NotFoundTodoException::new);
        isValidUserToUpdate(userId, todo.getUser().getId());
        todo.updateCompleted();
    }

    private void isValidUserToUpdate(final Long userId, final Long todoUserId) {
        if (!userId.equals(todoUserId)) {
            throw new ForbiddenUserToUpdateTodoException();
        }
    }

    public void deleteTodo(final Long userId, final Long todoId) {
        isValidUser(userId);
        final Todo todo = todoRepository.findById(todoId).orElseThrow(NotFoundTodoException::new);
        isValidUserToUpdate(userId, todo.getUser().getId());
        todo.updateDeleted();
    }

    @Transactional(readOnly = true)
    public ReadArticleDto readAllTodosByPagingOffset(final Pageable pageable) {
        final Page<Todo> todos = todoRepository.findAll(pageable);
        return ReadArticleDto.of(todos.getContent(), todos.getTotalPages());
    }

    @Transactional(readOnly = true)
    public ReadArticleByCursorDto readAllTodosByPagingCursor(
            final Long cursorId,
            final Pageable pageable
    ) {
        final List<Todo> todos;
        if (cursorId == null) {
            todos = todoRepository.findAll(pageable).getContent();
        } else {
            todos = todoRepository.findByIdGreaterThan(cursorId, pageable);
        }

        Long lastCursorId = todos.isEmpty() ? null : todos.get(todos.size() - 1).getId();
        return ReadArticleByCursorDto.of(lastCursorId, todos);
    }
}
