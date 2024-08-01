package com.cinelits.ms.accountskt.database.models

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "tb_users", uniqueConstraints = [
    UniqueConstraint(columnNames = ["email", "username"])
])
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "identifier", length = 36)
    val identifier: UUID? = null,
    @Column(name = "first_name", length = 255)
    var firstName: String?,
    @Column(name = "last_name", length = 255)
    var lastName: String?,
    @Column(name = "username", length = 20)
    var username: String?,
    @Column(name = "email", length = 255)
    var email: String?,
    @Column(name = "password", length = 255)
    var password: String?,
    @Column(name = "biography", length = 255)
    var biography: String?,
    @Column(name = "location", length = 255)
    var location: String?,
    @Column(name = "photo_url", length = 255)
    var photoUrl: String?,
    @Column(name = "birth_date")
    var birthDate: LocalDate?,
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    val createdAt: LocalDateTime? = null,
    @Column(name = "updated_at")
    var updatedAt: LocalDateTime? = null
)
