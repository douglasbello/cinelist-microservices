package com.cinelist.ms.ratings.database.repositories;

import com.cinelist.ms.ratings.database.models.MovieRating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MovieRatingRepository extends JpaRepository<MovieRating, UUID> {
}