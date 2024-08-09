package com.cinelist.ms.ratings.services.ratings.register.impl;

import com.cinelist.ms.ratings.client.MoviesClient;
import com.cinelist.ms.ratings.client.UsersClient;
import com.cinelist.ms.ratings.database.models.Rating;
import com.cinelist.ms.ratings.database.repositories.RatingRepository;
import com.cinelist.ms.ratings.dtos.client.MovieResponse;
import com.cinelist.ms.ratings.dtos.client.UserResponse;
import com.cinelist.ms.ratings.dtos.rating.RateRequest;
import com.cinelist.ms.ratings.services.ratings.register.RatingRegisterService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RatingRegisterServiceImpl implements RatingRegisterService {
    private final RatingRepository ratingRepository;
    private final MoviesClient moviesClient;
    private final UsersClient usersClient;

    public RatingRegisterServiceImpl(RatingRepository ratingRepository, MoviesClient moviesClient, UsersClient usersClient) {
        this.ratingRepository = ratingRepository;
        this.moviesClient = moviesClient;
        this.usersClient = usersClient;
    }

    @Transactional
    @Override
    public void rate(RateRequest request) {
        MovieResponse movieExists = moviesClient.findByIdentifier(request.mediaIdentifier()).getBody();
        UserResponse userExists = usersClient.findByIdentifier(request.userIdentifier()).getBody();

        Rating rate = new Rating(request.value(), movieExists.identifier(), userExists.identifier());
        ratingRepository.save(rate);
    }
}