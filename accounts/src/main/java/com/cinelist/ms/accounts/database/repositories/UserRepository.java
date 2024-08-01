package com.cinelist.ms.accounts.database.repositories;

import com.cinelist.ms.accounts.database.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByIdentifier(UUID identifier);
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
}