package com.cinelits.ms.accountskt.controllers.users.search

import com.cinelits.ms.accountskt.database.models.User
import org.springframework.http.ResponseEntity

interface UserSearchController {
    fun findByUsernameOrByEmailOrByIdentifier(targetIdentifier: String): ResponseEntity<User>
}