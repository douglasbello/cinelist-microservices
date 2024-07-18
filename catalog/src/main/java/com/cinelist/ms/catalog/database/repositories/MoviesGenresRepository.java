package com.cinelist.ms.catalog.database.repositories;

import com.cinelist.ms.catalog.database.models.MoviesGenres;
import com.cinelist.ms.catalog.database.models.MoviesGenresId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviesGenresRepository extends JpaRepository<MoviesGenres, MoviesGenresId> {
    Page<MoviesGenres> findAllByGenreIdentifier(String genreIdentifier, Pageable pageable);
}