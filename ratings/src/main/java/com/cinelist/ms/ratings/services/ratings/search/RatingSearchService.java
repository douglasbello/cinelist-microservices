package com.cinelist.ms.ratings.services.ratings.search;

import com.cinelist.ms.ratings.database.models.Rating;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface RatingSearchService {
    Rating findByIdentifier(UUID identifier);
    Page<Rating> findByMediaIdentifier(UUID mediaIdentifier);
    Page<Rating> findByUserIdentifier(UUID userIdentifier);
}