package com.cinelist.ms.accounts.database.repositories;

import com.cinelist.ms.accounts.database.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByIdentifier(String identifier);
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
}