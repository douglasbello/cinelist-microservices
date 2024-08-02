package com.cinelits.ms.accounts.services.users.watchlist.movies.impl

import com.cinelits.ms.accounts.client.MoviesClient
import com.cinelits.ms.accounts.database.models.UserWatchlistMovies
import com.cinelits.ms.accounts.database.models.UserWatchlistMoviesId
import com.cinelits.ms.accounts.database.repositories.UserWatchlistMoviesRepository
import com.cinelits.ms.accounts.dtos.client.MovieResponse
import com.cinelits.ms.accounts.services.users.search.UserSearchService
import com.cinelits.ms.accounts.services.users.watchlist.movies.WatchlistMoviesService
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class WatchlistMoviesServiceImpl(
    private val userWatchlistMoviesRepository: UserWatchlistMoviesRepository,
    private val userSearchService: UserSearchService,
    private val moviesClient: MoviesClient
) : WatchlistMoviesService {

    override fun addMovie(userIdentifier: UUID, movieIdentifier: UUID) {
        userSearchService.findByIdentifier(userIdentifier)
        moviesClient.findByIdentifier(movieIdentifier)

        val id = UserWatchlistMoviesId(userIdentifier, movieIdentifier)
        val watchListMovie = UserWatchlistMovies(id = id, createdAt = null, updatedAt = null)
        userWatchlistMoviesRepository.save(watchListMovie)
    }

    override fun getWatchlist(userIdentifier: UUID, pageable: Pageable): Page<MovieResponse> {
        val relations: Page<UUID> = userWatchlistMoviesRepository.getUserWatchlist(userIdentifier, pageable)

        val response: List<MovieResponse> =
            moviesClient.findAllByIdentifier(relations.content, pageable).body?.content ?: emptyList()

        return PageImpl(response, pageable, relations.totalElements )
    }
}