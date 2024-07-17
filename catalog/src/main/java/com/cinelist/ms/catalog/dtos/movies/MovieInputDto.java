package com.cinelist.ms.catalog.dtos.movies;

import java.time.LocalDate;

public record MovieInputDto(String title, String shortDescription, String longDescription, LocalDate releaseDate, String trailerUrl, String thumbnailUrl,
                            String certificateId, String duration) {
}