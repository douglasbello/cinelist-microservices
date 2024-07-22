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

        request = new MovieRequest("Interstellar", null, null, null, null, null, null, null);

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