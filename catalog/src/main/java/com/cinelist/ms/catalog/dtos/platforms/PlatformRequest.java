package com.cinelist.ms.catalog.dtos.platforms;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PlatformRequest(@NotNull(message = "Name cannot be null.") @NotBlank(message = "Name cannot be blank.") String name) {
}