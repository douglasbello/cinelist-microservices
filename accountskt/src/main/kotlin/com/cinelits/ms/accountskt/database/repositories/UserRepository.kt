package com.cinelits.ms.accountskt.database.repositories

import com.cinelits.ms.accountskt.database.models.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional
import java.util.UUID

interface UserRepository : JpaRepository<User, UUID>{
    fun findByIdentifier(identifier: UUID): Optional<User>
    fun findByUsername(username: String?): Optional<User>
    fun findByEmail(email: String?): Optional<User>
}