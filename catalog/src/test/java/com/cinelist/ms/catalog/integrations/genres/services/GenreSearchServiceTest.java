package com.cinelist.ms.catalog.integrations.genres.services;

import com.cinelist.ms.catalog.database.models.Genre;
import com.cinelist.ms.catalog.database.repositories.GenreRepository;
import com.cinelist.ms.catalog.services.search.impl.GenreSearchServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class GenreSearchServiceTest {
    @Autowired
    private GenreSearchServiceImpl genreSearchService;

    @Autowired
    private GenreRepository genreRepository;

    @Test
    void whenSaved_thenFindsByName() {
        Genre genre = genreRepository.save(new Genre("Fiction"));

        Genre foundGenre = genreSearchService.findByName(genre.getName());

        System.out.println(foundGenre);

        assertNotNull(genre);
        assertNotNull(foundGenre);
        assertEquals(genre.getName(), foundGenre.getName());
    }

    @Test
    void findByName() {
        Genre foundGenre = genreSearchService.findByName("fiction");

        System.out.println(foundGenre);

        assertNotNull(foundGenre);
    }
}