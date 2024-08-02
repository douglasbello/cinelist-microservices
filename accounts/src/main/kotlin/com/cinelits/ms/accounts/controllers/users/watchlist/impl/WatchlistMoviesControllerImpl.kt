package com.cinelits.ms.accounts.controllers.users.watchlist.impl

import com.cinelits.ms.accounts.controllers.users.watchlist.WatchlistMoviesController
import com.cinelits.ms.accounts.dtos.client.MovieResponse
import com.cinelits.ms.accounts.services.users.watchlist.movies.WatchlistMoviesService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/watchlist/movies")
class WatchlistMoviesControllerImpl(
    private val watchlistMoviesService: WatchlistMoviesService
) : WatchlistMoviesController {

    @PostMapping("/{movieIdentifier}/user/{userIdentifier}")
    override fun addMovie(@PathVariable userIdentifier: UUID, @PathVariable movieIdentifier: UUID): ResponseEntity<Void> {
        watchlistMoviesService.addMovie(userIdentifier, movieIdentifier)

        return ResponseEntity.noContent().build()
    }

    @GetMapping("/user/{userIdentifier}")
    override fun getWatchlist(@PathVariable userIdentifier: UUID, pageable: Pageable): ResponseEntity<Page<MovieResponse>> {
        return ResponseEntity.ok().body(watchlistMoviesService.getWatchlist(userIdentifier, pageable))
    }
}