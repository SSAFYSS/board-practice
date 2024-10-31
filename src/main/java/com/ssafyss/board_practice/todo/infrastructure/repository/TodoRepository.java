package com.ssafyss.board_practice.todo.infrastructure.repository;

import com.ssafyss.board_practice.todo.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    Optional<Todo> findById(Long id);
    List<Todo> findAllByDeletedFalse();
}
