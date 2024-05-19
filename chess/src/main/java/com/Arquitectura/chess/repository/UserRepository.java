package com.Arquitectura.chess.repository;

import com.Arquitectura.chess.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByUsernameAndPassword(String username, String password);
    User findByUsername(String username);
}
