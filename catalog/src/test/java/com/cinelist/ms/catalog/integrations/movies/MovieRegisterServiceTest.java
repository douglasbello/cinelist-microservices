package com.cinelist.ms.catalog.integrations.movies;

import com.cinelist.ms.catalog.database.models.Movie;
import com.cinelist.ms.catalog.database.repositories.MovieRepository;
import com.cinelist.ms.catalog.dtos.movies.MovieRequest;
import com.cinelist.ms.catalog.services.certificates.CertificateService;
import com.cinelist.ms.catalog.services.register.impl.MovieRegisterServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;


import java.util.UUID;

@SpringBootTest
public class MovieRegisterServiceTest {
    @InjectMocks
    private MovieRegisterServiceImpl movieRegisterService;

    @Mock
    private MovieRepository movieRepository;

    @Mock
    private CertificateService certificateService;

    @Test
    public void testGetMovieById() {
        String movieIdentifier = UUID.randomUUID().toString();

        MovieRequest request = new MovieRequest("Interstellar", null, null, null, null, null, null, null);

        Movie movie = movieRegisterService.register(request);

        assertThat(movie).isNotNull();
    }
}