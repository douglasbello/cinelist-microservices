package com.cinelist.ms.ratings.dtos.rating;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record RateRequest(@NotNull(message = "Rate value cannot be null.")
                          @Min(value = 0, message = "Rate value cannot be negative.")
                          @Max(value = 10, message = "Rate value cannot be bigger than 10.")
                          Double value,
                          UUID mediaIdentifier
) {
}