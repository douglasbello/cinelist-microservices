package com.cinelist.ms.accounts.services.users;

import com.cinelist.ms.accounts.database.models.User;
import com.cinelist.ms.accounts.handlers.exceptions.UserNotFoundException;

public interface UserService {
    User save(User user);
    User findUserByUsernameOrEmailOrIdentifier(String targetUserIdentifier) throws UserNotFoundException;
}