package com.cinelist.ms.catalog.dtos.genres;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record GenreRequest(@NotNull(message = "Name cannot be null.") @NotBlank(message = "Name cannot be blank.") String name) {
}