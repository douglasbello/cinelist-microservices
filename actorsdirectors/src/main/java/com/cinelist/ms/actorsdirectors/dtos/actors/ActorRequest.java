package com.cinelist.ms.actorsdirectors.dtos.actors;

import java.time.LocalDate;

public record ActorRequest(String firstName, String lastName, LocalDate birthDate, String photoUrl) {
}