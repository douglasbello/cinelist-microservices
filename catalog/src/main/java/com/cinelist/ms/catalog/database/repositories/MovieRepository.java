package com.cinelist.ms.catalog.database.repositories;

import com.cinelist.ms.catalog.database.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, String> {
}
