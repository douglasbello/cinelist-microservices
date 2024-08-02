package com.cinelits.ms.accounts.dtos.client

import java.time.LocalDate
import java.util.UUID

data class MovieResponse(
    val identifier: UUID,
    val title: String?,
    val shortDescription: String?,
    val releaseDate: LocalDate?,
    val trailerUrl: String?,
    val thumbnailUrl: String?,
    val certificateIdentifier: UUID?,
    val languageIdentifier: UUID?,
    val duration: String?
)