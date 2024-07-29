package com.cinelist.ms.actorsdirectors.database.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_directors")
public class Director extends Person {
}