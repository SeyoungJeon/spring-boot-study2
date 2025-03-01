package com.example.demo.repository;

import com.example.demo.Board;
import com.example.demo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findByUser(User user);
}
