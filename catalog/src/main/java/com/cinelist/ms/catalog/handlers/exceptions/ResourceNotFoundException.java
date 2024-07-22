package com.cinelist.ms.catalog.handlers.exceptions;

import java.io.Serial;

public class ResourceNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String resourceName, String identifier) {
        super(resourceName + " not found with identifier: " + identifier);
    }
}