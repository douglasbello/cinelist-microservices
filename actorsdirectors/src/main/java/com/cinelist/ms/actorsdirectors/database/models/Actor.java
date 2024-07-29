package com.cinelist.ms.actorsdirectors.database.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "tb_actors")
public class Actor extends Person {
    public Actor() {
    }

    public Actor(String firstName, String lastName, LocalDate birthDate, String photoUrl) {
        super(firstName, lastName, birthDate, photoUrl);
    }
}