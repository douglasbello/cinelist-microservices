package com.cinelist.ms.cast.controllers.update.impl;

import com.cinelist.ms.cast.controllers.update.CastUpdateController;
import com.cinelist.ms.cast.dtos.castmovie.CastMovieRequest;
import com.cinelist.ms.cast.services.update.CastUpdateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/casts")
public class CastUpdateControllerImpl implements CastUpdateController {
    private final CastUpdateService castUpdateService;

    public CastUpdateControllerImpl(CastUpdateService castUpdateService) {
        this.castUpdateService = castUpdateService;
    }

    @PutMapping
    public ResponseEntity<Void> addCastToMovie(@RequestBody CastMovieRequest request) {
        castUpdateService.addCastToMovie(request);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{castIdentifier}/addoccupation/{occupationIdentifier}")
    public ResponseEntity<Void> addOccupationToCast(@PathVariable UUID castIdentifier, @PathVariable UUID occupationIdentifier) {
        castUpdateService.addOccupationToCast(castIdentifier, occupationIdentifier);

        return ResponseEntity.noContent().build();
    }
}