package com.cinelist.ms.ratings.controllers.ratings.register.impl;

import com.cinelist.ms.ratings.controllers.ratings.register.RatingRegisterController;
import com.cinelist.ms.ratings.dtos.rating.RateRequest;
import com.cinelist.ms.ratings.services.ratings.register.RatingRegisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rating")
public class RatingRegisterControllerImpl implements RatingRegisterController {
    private final RatingRegisterService ratingRegisterService;

    public RatingRegisterControllerImpl(RatingRegisterService ratingRegisterService) {
        this.ratingRegisterService = ratingRegisterService;
    }

    @PostMapping("/rate")
    public ResponseEntity<Void> rate(@RequestBody RateRequest request) {
        ratingRegisterService.rate(request);

        return ResponseEntity.noContent().build();
    }
}