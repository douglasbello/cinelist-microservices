package com.cinelist.ms.catalog.integrations.movies.services;

import com.cinelist.ms.catalog.database.models.*;
import com.cinelist.ms.catalog.database.repositories.MovieRepository;
import com.cinelist.ms.catalog.database.repositories.MoviesGenresRepository;
import com.cinelist.ms.catalog.database.repositories.MoviesLanguagesRepository;
import com.cinelist.ms.catalog.database.repositories.MoviesPlatformsRepository;
import com.cinelist.ms.catalog.services.search.impl.MovieSearchServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class MovieSearchServiceTest {
    @InjectMocks
    private MovieSearchServiceImpl movieSearchService;

    @Mock
    private MovieRepository movieRepository;
    @Mock
    private MoviesGenresRepository moviesGenresRepository;
    @Mock
    private MoviesLanguagesRepository moviesLanguagesRepository;
    @Mock
    private MoviesPlatformsRepository moviesPlatformsRepository;

    static Movie matrix;

    static Movie interstellar;

    static {
        interstellar = new Movie.MovieBuilder()
                .setTitle("Interstellar")
                .build();

        matrix = new Movie.MovieBuilder()
                .setTitle("Matrix")
                .build();
    }

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(MovieSearchServiceTest.class);
    }

    @DisplayName("Should return list of movies")
    @Test
    void shouldReturnListOfMovies() {
        List<Movie> movies = List.of(interstellar, matrix);
        Page<Movie> page = new PageImpl<>(movies);

        Pageable pageable = PageRequest.of(0, 2);

        Mockito.when(movieRepository.findAll(pageable)).thenReturn(page);

        Page<Movie> retrievedMovies = movieSearchService.findAll(pageable);

        assertFalse(retrievedMovies.getContent().isEmpty());

        System.out.println(page.getContent());
    }

    @DisplayName("Should return list of movies found by genre identifier")
    @Test
    void givenGenreIdentifier_shouldReturnListOfMovies() {
        UUID genreIdentifier = UUID.randomUUID();
        UUID movieIdentifier = UUID.randomUUID();

        MoviesGenresId moviesGenresId = new MoviesGenresId(movieIdentifier, genreIdentifier);
        MoviesGenres moviesGenres = new MoviesGenres(moviesGenresId);

        Page<MoviesGenres> page = new PageImpl<>(List.of(moviesGenres));

        Pageable pageable = PageRequest.of(0, 2);

        Mockito.when(moviesGenresRepository.findAllByGenreIdentifier(genreIdentifier, pageable)).thenReturn(page);
        Mockito.when(movieRepository.findById(movieIdentifier)).thenReturn(Optional.of(interstellar));

        Page<Movie> movies = movieSearchService.findAllByGenreIdentifier(genreIdentifier, pageable);

        assertFalse(movies.getContent().isEmpty());

        System.out.println(movies.getContent());
    }

    @DisplayName("Should return list of movies found by language identifier")
    @Test
    void givenLanguageIdentifier_shouldReturnListOfMovies() {
        UUID languageIdentifier = UUID.randomUUID();
        UUID movieIdentifier = UUID.randomUUID();

        MoviesLanguagesId moviesLanguagesId = new MoviesLanguagesId(movieIdentifier, languageIdentifier);
        MoviesLanguages moviesLanguages = new MoviesLanguages(moviesLanguagesId);

        Page<MoviesLanguages> page = new PageImpl<>(List.of(moviesLanguages));

        Pageable pageable = PageRequest.of(0, 2);

        Mockito.when(moviesLanguagesRepository.findAllByLanguageIdentifier(languageIdentifier, pageable)).thenReturn(page);
        Mockito.when(movieRepository.findById(movieIdentifier)).thenReturn(Optional.of(interstellar));

        Page<Movie> movies = movieSearchService.findAllByLanguageIdentifier(languageIdentifier, pageable);

        assertFalse(movies.getContent().isEmpty());

        System.out.println(movies.getContent());
    }

    @DisplayName("Should return list of movies found by platform identifier")
    @Test
    void givenPlatformIdentifier_shouldReturnListOfMovies() {
        UUID platformIdentifier = UUID.randomUUID();
        UUID movieIdentifier = UUID.randomUUID();

        MoviesPlatformsId moviesPlatformsId = new MoviesPlatformsId(movieIdentifier, platformIdentifier);
        MoviesPlatforms moviesPlatforms = new MoviesPlatforms(moviesPlatformsId);

        Page<MoviesPlatforms> page = new PageImpl<>(List.of(moviesPlatforms));

        Pageable pageable = PageRequest.of(0, 2);

        Mockito.when(moviesPlatformsRepository.findAllByPlatformIdentifier(platformIdentifier, pageable)).thenReturn(page);
        Mockito.when(movieRepository.findById(movieIdentifier)).thenReturn(Optional.of(interstellar));

        Page<Movie> movies = movieSearchService.findAllByPlatformIdentifier(platformIdentifier, pageable);

        assertFalse(movies.getContent().isEmpty());

        System.out.println(movies.getContent());
    }

    @DisplayName("Should return list of movies found by certificate identifier")
    @Test
    void givenCertificateIdentifier_shouldReturnListOfMovies() {
        UUID certificateIdentifier = UUID.randomUUID();

        Pageable pageable = PageRequest.of(0, 2);
        Page<Movie> movies = new PageImpl<>(List.of(interstellar));

        Mockito.when(movieRepository.findAllByCertificateIdentifier(certificateIdentifier, pageable)).thenReturn(movies);

        Page<Movie> foundMovies = movieSearchService.findAllByCertificateIdentifier(certificateIdentifier, pageable);

        assertFalse(foundMovies.getContent().isEmpty());

        System.out.println(foundMovies);
    }
}