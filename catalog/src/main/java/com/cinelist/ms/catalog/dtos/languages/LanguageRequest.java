package com.cinelist.ms.catalog.dtos.languages;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LanguageRequest(@NotNull(message = "Name cannot be null.") @NotBlank(message = "Name cannot be blank.") String name) {
}