package com.cinelist.ms.cast.dtos.cast;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record CastRequest(String firstName, String lastName, LocalDate birthDate, String photoUrl, List<UUID> occupationIdentifiers) {
}