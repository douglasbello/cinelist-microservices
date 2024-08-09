package com.cinelist.ms.ratings.services.ratings.register;

import com.cinelist.ms.ratings.dtos.rating.RateRequest;

import java.util.UUID;

public interface RatingRegisterService {
    void rate(RateRequest request);
}