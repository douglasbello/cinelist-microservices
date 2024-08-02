package com.cinelits.ms.accounts.controllers.users.search

import com.cinelits.ms.accounts.database.models.User
import org.springframework.http.ResponseEntity

interface UserSearchController {
    fun findByUsernameOrByEmailOrByIdentifier(targetIdentifier: String): ResponseEntity<User>
}