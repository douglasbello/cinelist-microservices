package com.cinelist.ms.catalog.integrations.movies.controller;

import com.cinelist.ms.catalog.controllers.search.impl.MovieSearchControllerImpl;
import com.cinelist.ms.catalog.database.models.Movie;
import com.cinelist.ms.catalog.handlers.exceptions.ResourceNotFoundException;
import com.cinelist.ms.catalog.services.search.MovieSearchService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MovieSearchControllerTest {
    @InjectMocks
    MovieSearchControllerImpl movieSearchController;

    @Mock
    MovieSearchService movieSearchService;

    private static Movie interstellar;

    static {
        interstellar = new Movie.MovieBuilder()
                .setTitle("Interstellar")
                .setLanguageIdentifier(UUID.randomUUID())
                .build();

        interstellar.setIdentifier(UUID.randomUUID());
    }

    @Test
    void givenIdentifier_shouldReturnMovie() {
        UUID identifier = interstellar.getIdentifier();

        when(movieSearchService.details(interstellar.getIdentifier())).thenReturn(interstellar);

        ResponseEntity<Movie> response = movieSearchController.findByIdentifier(identifier);

        assertEquals(200, response.getStatusCode().value());
    }

    @Test
    void givenNonExistingIdentifier_shouldThrowResourceNotFoundException() {
        UUID identifier = UUID.randomUUID();

        when(movieSearchService.details(identifier)).thenThrow(new ResourceNotFoundException("Movie", identifier.toString()));

        assertThrows(ResourceNotFoundException.class, () -> movieSearchController.findByIdentifier(identifier));
    }

    @Test
    void givenLanguageIdentifier_shouldReturnPageOfMovies() {
        when(movieSearchService.findAllByLanguageIdentifier(interstellar.getLanguageIdentifier(), PageRequest.of(0, 4))).thenReturn(new PageImpl<>(List.of(interstellar)));

        Page<Movie> response = movieSearchService.findAllByLanguageIdentifier(interstellar.getLanguageIdentifier(), PageRequest.of(0, 4));

        assertFalse(response.getContent().isEmpty());
        System.out.println(response);
    }

    @Test
    void givenTitle_shouldReturnPageOfMovies() {
        when(movieSearchService.findAllByTitle(interstellar.getTitle(), PageRequest.of(0, 4))).thenReturn(new PageImpl<>(List.of(interstellar)));

        Page<Movie> response = movieSearchService.findAllByTitle(interstellar.getTitle(), PageRequest.of(0, 4));

        assertFalse(response.getContent().isEmpty());
    }
}
