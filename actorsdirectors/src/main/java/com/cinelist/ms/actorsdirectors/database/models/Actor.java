package com.cinelist.ms.actorsdirectors.database.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_actors")
public class Actor extends Person {
}