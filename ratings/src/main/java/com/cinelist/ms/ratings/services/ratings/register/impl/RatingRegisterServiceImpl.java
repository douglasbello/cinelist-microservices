package com.cinelist.ms.ratings.services.ratings.register.impl;

import com.cinelist.ms.ratings.client.MoviesClient;
import com.cinelist.ms.ratings.database.models.MovieRating;
import com.cinelist.ms.ratings.database.models.Rating;
import com.cinelist.ms.ratings.database.repositories.MovieRatingRepository;
import com.cinelist.ms.ratings.database.repositories.RatingRepository;
import com.cinelist.ms.ratings.dtos.client.MovieResponse;
import com.cinelist.ms.ratings.services.ratings.register.RatingRegisterService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class RatingRegisterServiceImpl implements RatingRegisterService {
    private final RatingRepository ratingRepository;
    private final MoviesClient moviesClient;
    private final MovieRatingRepository movieRatingRepository;

    public RatingRegisterServiceImpl(RatingRepository ratingRepository, MoviesClient moviesClient, MovieRatingRepository movieRatingRepository) {
        this.ratingRepository = ratingRepository;
        this.moviesClient = moviesClient;
        this.movieRatingRepository = movieRatingRepository;
    }

    @Transactional
    @Override
    public void rate(UUID movieIdentifier, Double value) {
        MovieResponse movieExists = moviesClient.findByIdentifier(movieIdentifier).getBody();

        Rating rate = new Rating(value);
        rate = ratingRepository.save(rate);

        MovieRating relation = new MovieRating(movieExists.identifier(), rate.getIdentifier());
        movieRatingRepository.save(relation);
    }
}