package com.cinelist.ms.accounts.handlers.exceptions;

import java.io.Serial;

public class UserNotFoundException extends RuntimeException {
    @Serial
    private final static long serialVersionUID = 1L;

    public UserNotFoundException() {
        super("User not found.");
    }
}