package com.cinelist.ms.catalog.integrations.movies.services;

import com.cinelist.ms.catalog.database.models.Language;
import com.cinelist.ms.catalog.database.models.Movie;
import com.cinelist.ms.catalog.database.repositories.LanguageRepository;
import com.cinelist.ms.catalog.database.repositories.MovieRepository;
import com.cinelist.ms.catalog.dtos.movies.MovieRequest;
import com.cinelist.ms.catalog.services.register.impl.MovieRegisterServiceImpl;
import com.cinelist.ms.catalog.services.search.CertificateSearchService;
import com.cinelist.ms.catalog.services.search.LanguageSearchService;
import com.cinelist.ms.catalog.services.update.MovieUpdateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class MovieRegisterServiceTest {
    @InjectMocks
    private MovieRegisterServiceImpl movieRegisterService;

    @Mock
    private CertificateSearchService certificateSearchService;

    @Mock
    private MovieUpdateService movieUpdateService;

    @Mock
    private LanguageSearchService languageSearchService;

    @Mock
    private LanguageRepository languageRepository;

    @Mock
    private MovieRepository movieRepository;

    private MovieRequest request;

    private Movie movie;

    List<UUID> platformsIdentifiers = new ArrayList<>();
    List<UUID> genresIdentifiers = new ArrayList<>();

    private Language english = new Language("English");

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(MovieRegisterServiceTest.class);

        platformsIdentifiers.add(UUID.fromString("8657bded-74a8-4f01-a877-c0eed45d94b5"));
        genresIdentifiers.add(UUID.fromString("a230ee11-55ac-43cb-b7dd-337832182c66"));

        request = new MovieRequest("Interstellar", "Short Description", "Long Description", LocalDate.of(2014, 11, 6), null,
                null, null, UUID.randomUUID(), null, null, null);

        movie = new Movie.MovieBuilder()
                .setTitle(request.title())
                .setThumbnailUrl(request.thumbnailUrl())
                .setTrailerUrl(request.trailerUrl())
                .setReleaseDate(request.releaseDate())
                .setLongDescription(request.longDescription())
                .setShortDescription(request.shortDescription())
                .setDuration(request.duration())
                .setCertificateIdentifier(request.certificateIdentifier())
                .setLanguageIdentifier(request.languageIdentifier())
                .build();
    }

    @DisplayName("Given MovieRequest when save should return saved movie")
    @Test
    void givenMovieRequest_whenSave_thenReturnSavedMovie() {
        when(movieRepository.save(any(Movie.class))).thenReturn(movie);
        when(languageRepository.findById(any(UUID.class))).thenReturn(Optional.of(english));

        Movie savedMovie = movieRegisterService.register(request);

        assertNotNull(savedMovie);
        assertEquals("Interstellar", savedMovie.getTitle());

        System.out.println(savedMovie);
    }
}