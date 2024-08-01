package com.cinelist.ms.accounts.services.users.impl;

import com.cinelist.ms.accounts.database.models.User;
import com.cinelist.ms.accounts.database.repositories.UserRepository;
import com.cinelist.ms.accounts.handlers.exceptions.UserNotFoundException;
import com.cinelist.ms.accounts.services.users.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public User findUserByUsernameOrEmailOrIdentifier(String targetUserIdentifier) throws UserNotFoundException {
        Optional<User> user;

        user = userRepository.findByUsername(targetUserIdentifier);
        if (user.isEmpty())
            user = userRepository.findByEmail(targetUserIdentifier);
        if (user.isEmpty())
            user = userRepository.findByIdentifier(UUID.fromString(targetUserIdentifier));
        if (user.isEmpty())
            throw new UserNotFoundException();

        return user.get();
    }
}