package com.cinelist.ms.catalog.integrations.genres.services;

import com.cinelist.ms.catalog.database.models.Genre;
import com.cinelist.ms.catalog.database.repositories.GenreRepository;
import com.cinelist.ms.catalog.services.search.impl.GenreSearchServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
public class GenreSearchServiceTest {
    @InjectMocks
    private GenreSearchServiceImpl genreSearchService;

    @Mock
    private GenreRepository genreRepository;

    private Genre genre;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(GenreSearchServiceTest.class);

        genre = new Genre("Fiction");
    }

    @DisplayName("Given genre name, should return genre")
    @Test
    void givenName_shouldReturnGenre() {
        when(genreRepository.findByName(anyString())).thenReturn(genre);

        Genre foundGenre = genreSearchService.findByName(genre.getName());

        System.out.println(foundGenre);

        assertNotNull(foundGenre);
        assertEquals(foundGenre.getName(), genre.getName());
    }
}