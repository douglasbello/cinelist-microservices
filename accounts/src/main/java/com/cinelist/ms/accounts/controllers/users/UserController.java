package com.cinelist.ms.accounts.controllers.users;

import com.cinelist.ms.accounts.database.models.User;
import org.springframework.http.ResponseEntity;

public interface UserController {
    ResponseEntity<User> save(User user);
    ResponseEntity<User> findByUsernameOrByEmailOrByIdentifier(String targetUserIdentifier);
}