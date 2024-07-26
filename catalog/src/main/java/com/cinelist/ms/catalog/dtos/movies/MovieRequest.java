package com.cinelist.ms.catalog.dtos.movies;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record MovieRequest(@NotNull(message = "Title cannot be null.") @NotBlank(message = "Title cannot be blank.") String title, String shortDescription, String longDescription, LocalDate releaseDate, String trailerUrl, String thumbnailUrl,
                           UUID certificateIdentifier, UUID languageIdentifier, String duration, List<UUID> genresIdentifiers, List<UUID> platformsIdentifiers) {
}