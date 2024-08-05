package com.cinelist.ms.ratings.database.repositories;

import com.cinelist.ms.ratings.database.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RatingRepository extends JpaRepository<Rating, UUID> {
}