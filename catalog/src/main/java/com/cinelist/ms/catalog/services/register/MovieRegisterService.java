package com.cinelist.ms.catalog.services.register;

import com.cinelist.ms.catalog.database.models.Movie;
import com.cinelist.ms.catalog.dtos.movies.MovieRequest;

public interface MovieRegisterService {
    Movie register(MovieRequest request);
}