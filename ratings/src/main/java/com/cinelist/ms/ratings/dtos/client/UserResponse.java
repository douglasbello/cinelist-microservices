package com.cinelist.ms.ratings.dtos.client;

import java.util.UUID;

public record UserResponse(
        UUID identifier,
        String firstName,
        String lastName,
        String username,
        String email,
        String biography,
        String location,
        String photoUrl,
        String birthDate
) {
}