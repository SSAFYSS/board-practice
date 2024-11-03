package com.ssafyss.board_practice.user.infrastructure.repository;

import com.ssafyss.board_practice.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long id);
}
