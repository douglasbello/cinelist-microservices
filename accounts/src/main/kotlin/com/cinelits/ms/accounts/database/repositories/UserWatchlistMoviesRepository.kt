package com.cinelits.ms.accounts.database.repositories

import com.cinelits.ms.accounts.database.models.UserWatchlistMovies
import com.cinelits.ms.accounts.database.models.UserWatchlistMoviesId
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.util.UUID

interface UserWatchlistMoviesRepository : JpaRepository<UserWatchlistMovies, UserWatchlistMoviesId> {
    @Query(value = "SELECT w FROM UserWatchlistMovies w WHERE w.id.userIdentifier = :userIdentifier")
    fun getUserWatchlist(@Param("userIdentifier") userIdentifier: UUID, pageable: Pageable): Page<UserWatchlistMovies>
}