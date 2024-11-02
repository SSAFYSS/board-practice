package com.ssafyss.board_practice.todo.infrastructure;

import com.ssafyss.board_practice.todo.domain.Todo;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    Optional<Todo> findById(Long id);
    List<Todo> findAllByDeletedFalse();
    List<Todo> findByUserIdAndIdGreaterThanOrderByIdAsc(Long userId, Long id, Pageable pageable);
    List<Todo> findByUserIdOrderByIdAsc(Long userId, Pageable pageable);
}
