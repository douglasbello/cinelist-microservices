package com.cinelist.ms.catalog.handlers.exceptions;

import java.io.Serial;

public class ResourceNotFound extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public ResourceNotFound(String identifier) {
        super("Resource not found with identifier: " + identifier);
    }
}