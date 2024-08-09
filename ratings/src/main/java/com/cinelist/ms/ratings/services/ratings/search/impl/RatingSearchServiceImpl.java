package com.cinelist.ms.ratings.services.ratings.search.impl;

import com.cinelist.ms.ratings.database.models.Rating;
import com.cinelist.ms.ratings.database.repositories.RatingRepository;
import com.cinelist.ms.ratings.handlers.exceptions.ResourceNotFoundException;
import com.cinelist.ms.ratings.services.ratings.search.RatingSearchService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RatingSearchServiceImpl implements RatingSearchService {
    private final RatingRepository ratingRepository;

    public RatingSearchServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public Rating findByIdentifier(UUID identifier) {
        return ratingRepository.findById(identifier).orElseThrow(() -> new ResourceNotFoundException("Rating", identifier));
    }

    @Override
    public Page<Rating> findByMediaIdentifier(UUID mediaIdentifier) {
        return ratingRepository.findByMediaIdentifier(mediaIdentifier);
    }

    @Override
    public Page<Rating> findByUserIdentifier(UUID userIdentifier) {
        return ratingRepository.findByUserIdentifier(userIdentifier);
    }
}