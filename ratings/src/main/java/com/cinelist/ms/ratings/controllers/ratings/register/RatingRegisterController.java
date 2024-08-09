package com.cinelist.ms.ratings.controllers.ratings.register;

import com.cinelist.ms.ratings.dtos.rating.RateRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

@Validated
public interface RatingRegisterController {
    ResponseEntity<Void> rate(@Valid RateRequest request);
}