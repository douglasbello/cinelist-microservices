package com.cinelist.ms.cast.dtos.occupations;

import jakarta.validation.constraints.NotEmpty;

public record OccupationRequest(@NotEmpty(message = "Name cannot be null or blank.") String name) {
}