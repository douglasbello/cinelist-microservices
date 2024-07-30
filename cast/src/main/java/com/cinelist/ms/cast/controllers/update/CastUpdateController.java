package com.cinelist.ms.cast.controllers.update;

import com.cinelist.ms.cast.dtos.castmovie.CastMovieRequest;
import org.springframework.http.ResponseEntity;

public interface CastUpdateController {
    ResponseEntity<Void> addCastToMovie(CastMovieRequest request);
}