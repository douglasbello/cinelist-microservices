package com.cinelist.ms.actorsdirectors.dtos.cast;

import java.time.LocalDate;
import java.util.UUID;

public record CastRequest(String firstName, String lastName, LocalDate birthDate, String photoUrl, UUID occupationIdentifier) {
}