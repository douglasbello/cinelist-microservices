package com.cinelist.ms.catalog.database.repositories;

import com.cinelist.ms.catalog.database.models.MoviesGenres;
import com.cinelist.ms.catalog.database.models.MoviesGenresId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface MoviesGenresRepository extends JpaRepository<MoviesGenres, MoviesGenresId> {
    @Query(value = "SELECT mg FROM MoviesGenres mg WHERE mg.id.genreIdentifier = :identifier")
    Page<MoviesGenres> findAllByGenreIdentifier(@Param("identifier") UUID genreIdentifier, Pageable pageable);
}