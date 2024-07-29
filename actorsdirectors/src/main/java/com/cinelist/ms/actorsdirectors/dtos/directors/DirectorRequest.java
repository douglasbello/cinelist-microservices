package com.cinelist.ms.actorsdirectors.dtos.directors;

import java.time.LocalDate;

public record DirectorRequest(String firstName, String lastName, LocalDate birthDate, String photoUrl) {
}