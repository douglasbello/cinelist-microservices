package com.cinelist.ms.catalog.integrations.movies.services;

import com.cinelist.ms.catalog.database.models.Movie;
import com.cinelist.ms.catalog.database.repositories.MovieRepository;
import com.cinelist.ms.catalog.dtos.movies.MovieRequest;
import com.cinelist.ms.catalog.services.register.impl.MovieRegisterServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class MovieRegisterServiceTest {
    @Autowired
    private MovieRegisterServiceImpl movieRegisterService;

    @Mock
    private MovieRepository movieRepository;

    private MovieRequest request;

    private Movie movie;

    List<UUID> platformsIdentifiers = new ArrayList<>();
    List<UUID> genresIdentifiers = new ArrayList<>();
    List<UUID> languagesIdentifiers = new ArrayList<>();

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(MovieRegisterServiceTest.class);

        platformsIdentifiers.add(UUID.fromString("8657bded-74a8-4f01-a877-c0eed45d94b5"));
        genresIdentifiers.add(UUID.fromString("a230ee11-55ac-43cb-b7dd-337832182c66"));
        languagesIdentifiers.add(UUID.fromString("4b35ea67-bd6d-4a55-8eb4-b246e08dabf6"));

        request = new MovieRequest("Interstellar", "Short Description", "Long Description", LocalDate.of(2014, 11, 6), null,
                null, null, null, null, null, null);

        movie = new Movie.MovieBuilder()
                .setTitle(request.title())
                .setThumbnailUrl(request.thumbnailUrl())
                .setTrailerUrl(request.trailerUrl())
                .setReleaseDate(request.releaseDate())
                .setLongDescription(request.longDescription())
                .setShortDescription(request.shortDescription())
                .setDuration(request.duration())
                .build();
    }

    @DisplayName("Given MovieRequest when save should return saved movie")
    @Test
    void givenMovieRequest_whenSave_thenReturnSavedMovie() {
        when(movieRepository.save(any(Movie.class))).thenReturn(movie);

        Movie savedMovie = movieRegisterService.register(request);

        assertNotNull(savedMovie);
        assertEquals("Interstellar", savedMovie.getTitle());
    }
}