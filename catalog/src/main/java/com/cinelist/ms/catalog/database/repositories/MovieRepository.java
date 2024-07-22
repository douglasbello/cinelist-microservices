package com.cinelist.ms.catalog.database.repositories;

import com.cinelist.ms.catalog.database.models.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MovieRepository extends JpaRepository<Movie, UUID> {
    Page<Movie> findAllByCertificateIdentifier(UUID certificateIdentifier, Pageable pageable);
}