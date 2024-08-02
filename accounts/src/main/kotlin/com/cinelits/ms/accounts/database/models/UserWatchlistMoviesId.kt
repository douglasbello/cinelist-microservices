package com.cinelits.ms.accounts.database.models

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.util.UUID

@Embeddable
data class UserWatchlistMoviesId(
    @Column(name = "user_identifier", length = 36)
    val userIdentifier: UUID,
    @Column(name = "movie_identifier", length = 36)
    val movieIdentifier: UUID
)