package com.cinelist.ms.ratings.dtos.client;

import java.time.LocalDate;
import java.util.UUID;

public record MovieResponse(
        UUID identifier,
        String title,
        String shortDescription,
        String longDescription,
        LocalDate releaseDate,
        String trailerUrl,
        String thumbnailUrl,
        UUID certificateIdentifier,
        UUID languageIdentifier,
        String duration
) {
}