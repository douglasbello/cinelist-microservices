package com.cinelist.ms.cast.dtos.cast;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record CastRequest(@NotEmpty(message = "First name cannot be null or blank.") String firstName,
                          @NotEmpty(message = "Last name cannot be null or blank.") String lastName,
                          @NotNull(message = "Birth date cannot be null.") LocalDate birthDate,
                          String photoUrl,
                          List<UUID> occupationIdentifiers) {
}