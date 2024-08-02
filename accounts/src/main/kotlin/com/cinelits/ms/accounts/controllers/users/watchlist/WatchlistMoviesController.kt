package com.cinelits.ms.accounts.controllers.users.watchlist

import com.cinelits.ms.accounts.dtos.client.MovieResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import java.util.UUID

interface WatchlistMoviesController {
    fun addMovie(userIdentifier: UUID, movieIdentifier: UUID): ResponseEntity<Void>
    fun getWatchlist(userIdentifier: UUID, pageable: Pageable): ResponseEntity<Page<MovieResponse>>
}