package com.cinelist.ms.catalog.services.genres;

import com.cinelist.ms.catalog.database.models.Genre;

import java.util.List;

public interface GenreService {
    Genre register(Genre genre);
    Genre findByIdentifier(String identifier) throws RuntimeException;
    List<Genre> findAll();
}