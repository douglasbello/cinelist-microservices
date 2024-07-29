package com.cinelist.ms.catalog.integrations.movies.services;

import com.cinelist.ms.catalog.database.models.*;
import com.cinelist.ms.catalog.database.repositories.MoviesGenresRepository;
import com.cinelist.ms.catalog.database.repositories.MoviesPlatformsRepository;
import com.cinelist.ms.catalog.services.search.GenreSearchService;
import com.cinelist.ms.catalog.services.search.MovieSearchService;
import com.cinelist.ms.catalog.services.search.PlatformSearchService;
import com.cinelist.ms.catalog.services.update.impl.MovieUpdateServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.mockito.Mockito.*;

@SpringBootTest
public class MovieUpdateServiceTest {

    @InjectMocks
    private MovieUpdateServiceImpl movieUpdateService;

    @Mock
    private GenreSearchService genreSearchService;

    @Mock
    private MovieSearchService movieSearchService;

    @Mock
    private MoviesGenresRepository moviesGenresRepository;

    @Mock
    private PlatformSearchService platformSearchService;

    @Mock
    private MoviesPlatformsRepository moviesPlatformsRepository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(MovieUpdateServiceTest.class);
    }

    @Test
    void testAddGenreToMovie() {
        UUID genreId = UUID.randomUUID();
        UUID movieId = UUID.randomUUID();
        Genre genre = new Genre();
        Movie movie = new Movie.MovieBuilder().build();

        when(genreSearchService.findByIdentifier(genreId)).thenReturn(genre);
        when(movieSearchService.details(movieId)).thenReturn(movie);

        movieUpdateService.addGenreToMovie(genreId, movieId);

        verify(genreSearchService).findByIdentifier(genreId);
        verify(movieSearchService).details(movieId);
        verify(moviesGenresRepository).save(any(MoviesGenres.class));
    }

    @Test
    void testAddPlatformToMovie() {
        UUID platformId = UUID.randomUUID();
        UUID movieId = UUID.randomUUID();
        Platform platform = new Platform();
        Movie movie = new Movie.MovieBuilder().build();

        when(platformSearchService.findByIdentifier(platformId)).thenReturn(platform);
        when(movieSearchService.details(movieId)).thenReturn(movie);

        movieUpdateService.addPlatformToMovie(platformId, movieId);

        verify(platformSearchService).findByIdentifier(platformId);
        verify(movieSearchService).details(movieId);
        verify(moviesPlatformsRepository).save(any(MoviesPlatforms.class));
    }
}
