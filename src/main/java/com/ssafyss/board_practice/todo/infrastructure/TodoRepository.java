package com.ssafyss.board_practice.todo.infrastructure;

import com.ssafyss.board_practice.todo.domain.Todo;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    Optional<Todo> findById(Long id);
    List<Todo> findAllByDeletedFalse();
}
