package com.cinelist.ms.catalog.integrations.movies.services;

import com.cinelist.ms.catalog.services.search.impl.MovieSearchServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MovieSearchServiceTest {
    @Autowired
    private MovieSearchServiceImpl movieSearchService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }
}