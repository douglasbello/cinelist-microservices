package com.cinelist.ms.catalog.dtos.movies;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record MovieRequest(String title, String shortDescription, String longDescription, LocalDate releaseDate, String trailerUrl, String thumbnailUrl,
                           UUID certificateIdentifier, String duration, List<UUID> genresIdentifiers, List<UUID> languagesIdentifiers, List<UUID> platformsIdentifiers) {
}