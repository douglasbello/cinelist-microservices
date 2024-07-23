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

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);

        List<UUID> platformsIdentifiers = new ArrayList<>();
        List<UUID> genresIdentifiers = new ArrayList<>();
        List<UUID> languagesIdentifiers = new ArrayList<>();

        platformsIdentifiers.add(UUID.fromString("8657bded-74a8-4f01-a877-c0eed45d94b5"));
        genresIdentifiers.add(UUID.fromString("a230ee11-55ac-43cb-b7dd-337832182c66"));
        languagesIdentifiers.add(UUID.fromString("4b35ea67-bd6d-4a55-8eb4-b246e08dabf6"));

        request = new MovieRequest("Interstellar", "Short Description", "Long Description", LocalDate.of(2014, 11, 6), null,
                null, UUID.fromString("072a351f-0b85-452e-a0f7-469a2c2f26bc"), null, genresIdentifiers, languagesIdentifiers, platformsIdentifiers);

        movie = new Movie.MovieBuilder()
                .setTitle("Interstellar")
                .build();
    }

    @DisplayName("JUnit test for save movie operation")
    @Test
    void givenMovieRequest_whenSave_thenReturnSavedMovie() {
        when(movieRepository.save(any(Movie.class))).thenReturn(movie);

        Movie savedMovie = movieRegisterService.register(request);

        assertNotNull(savedMovie);
        assertEquals("Interstellar", savedMovie.getTitle());
    }
}