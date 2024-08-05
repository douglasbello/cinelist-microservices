package com.cinelist.ms.ratings.services.ratings.register;

import java.util.UUID;

public interface RatingRegisterService {
    void rate(UUID movieIdentifier, Double value);
}