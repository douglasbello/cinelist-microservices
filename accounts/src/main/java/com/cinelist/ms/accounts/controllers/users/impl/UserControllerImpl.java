package com.cinelist.ms.accounts.controllers.users.impl;

import com.cinelist.ms.accounts.controllers.users.UserController;
import com.cinelist.ms.accounts.database.models.User;
import com.cinelist.ms.accounts.services.users.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserControllerImpl implements UserController {
    private final UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        return ResponseEntity.ok().body(userService.save(user));
    }

    @GetMapping("/{identifier}")
    public ResponseEntity<User> findByUsernameOrByEmailOrByIdentifier(@PathVariable String identifier) {
        return ResponseEntity.ok().body(userService.findUserByUsernameOrEmailOrIdentifier(identifier));
    }
}