package com.cinelits.ms.accounts.services.users.watchlist.movies

import com.cinelits.ms.accounts.dtos.client.MovieResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.UUID

interface WatchlistMoviesService {
    fun addMovie(userIdentifier: UUID, movieIdentifier: UUID)
    fun getWatchlist(userIdentifier: UUID, pageable: Pageable): Page<MovieResponse>
}