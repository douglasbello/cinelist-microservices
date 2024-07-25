package com.cinelist.ms.catalog.services.register;

import com.cinelist.ms.catalog.database.models.Genre;
import com.cinelist.ms.catalog.dtos.genres.GenreRequest;

public interface GenreRegisterService {
    Genre register(GenreRequest request);
}