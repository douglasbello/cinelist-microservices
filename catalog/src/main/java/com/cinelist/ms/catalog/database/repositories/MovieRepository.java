package com.cinelist.ms.catalog.database.repositories;

import com.cinelist.ms.catalog.database.models.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface MovieRepository extends JpaRepository<Movie, UUID> {
    Page<Movie> findAllByCertificateIdentifier(UUID certificateIdentifier, Pageable pageable);
    Page<Movie> findAllByLanguageIdentifier(UUID languageIdentifier, Pageable pageable);
    @Query(value = "SELECT m FROM Movie m WHERE LOWER(m.title) LIKE LOWER(CONCAT('%', :title, '%'))")
    Page<Movie> findAllByTitle(@Param("title") String title, Pageable pageable);
    @Query(value = "SELECT m FROM Movie m WHERE m.releaseDate > CURRENT_DATE")
    Page<Movie> upcoming(Pageable pageable);
    @Query(value = "SELECT m FROM Movie m WHERE m.releaseDate <= CURRENT_DATE")
    Page<Movie> latest(Pageable pageable);
}