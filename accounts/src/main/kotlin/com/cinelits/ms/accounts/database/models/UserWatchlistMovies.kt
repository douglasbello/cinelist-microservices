package com.cinelits.ms.accounts.database.models

import jakarta.persistence.Column
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime

@Entity
@Table(name = "tb_user_watchlist_movies")
data class UserWatchlistMovies(
    @EmbeddedId val id: UserWatchlistMoviesId,
    @Column(name = "watched", columnDefinition = "boolean")
    var watched: Boolean = false,
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    val createdAt: LocalDateTime?,
    @Column(name = "updated_at")
    var updatedAt: LocalDateTime?
)