package com.cinelist.ms.catalog.integrations.movies.services;

import com.cinelist.ms.catalog.database.models.*;
import com.cinelist.ms.catalog.database.repositories.MoviesGenresRepository;
import com.cinelist.ms.catalog.database.repositories.MoviesLanguagesRepository;
import com.cinelist.ms.catalog.database.repositories.MoviesPlatformsRepository;
import com.cinelist.ms.catalog.services.search.GenreSearchService;
import com.cinelist.ms.catalog.services.search.LanguageSearchService;
import com.cinelist.ms.catalog.services.search.MovieSearchService;
import com.cinelist.ms.catalog.services.search.PlatformSearchService;
import com.cinelist.ms.catalog.services.update.impl.MovieUpdateServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.mockito.Mockito.*;

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

    @Mock
    private LanguageSearchService languageSearchService;

    @Mock
    private MoviesLanguagesRepository moviesLanguagesRepository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddGenreToMovie() {
        UUID genreId = UUID.randomUUID();
        UUID movieId = UUID.randomUUID();
        Genre genre = new Genre();
        Movie movie = new Movie.MovieBuilder().build();

        when(genreSearchService.findByIdentifier(genreId)).thenReturn(genre);
        when(movieSearchService.findByIdentifier(movieId)).thenReturn(movie);

        movieUpdateService.addGenreToMovie(genreId, movieId);

        verify(genreSearchService).findByIdentifier(genreId);
        verify(movieSearchService).findByIdentifier(movieId);
        verify(moviesGenresRepository).save(any(MoviesGenres.class));
    }

    @Test
    void testAddPlatformToMovie() {
        UUID platformId = UUID.randomUUID();
        UUID movieId = UUID.randomUUID();
        Platform platform = new Platform();
        Movie movie = new Movie.MovieBuilder().build();

        when(platformSearchService.findByIdentifier(platformId)).thenReturn(platform);
        when(movieSearchService.findByIdentifier(movieId)).thenReturn(movie);

        movieUpdateService.addPlatformToMovie(platformId, movieId);

        verify(platformSearchService).findByIdentifier(platformId);
        verify(movieSearchService).findByIdentifier(movieId);
        verify(moviesPlatformsRepository).save(any(MoviesPlatforms.class));
    }

    @Test
    void testAddLanguageToMovie() {
        UUID languageId = UUID.randomUUID();
        UUID movieId = UUID.randomUUID();
        Language language = new Language();
        Movie movie = new Movie.MovieBuilder().build();

        when(languageSearchService.findByIdentifier(languageId)).thenReturn(language);
        when(movieSearchService.findByIdentifier(movieId)).thenReturn(movie);

        movieUpdateService.addLanguageToMovie(languageId, movieId);

        verify(languageSearchService).findByIdentifier(languageId);
        verify(movieSearchService).findByIdentifier(movieId);
        verify(moviesLanguagesRepository).save(any(MoviesLanguages.class));
    }
}