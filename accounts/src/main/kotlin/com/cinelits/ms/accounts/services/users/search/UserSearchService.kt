package com.cinelits.ms.accounts.services.users.search

import com.cinelits.ms.accounts.database.models.User
import java.util.UUID

interface UserSearchService {
    fun findByIdentifier(identifier: UUID): User
    fun findByUsernameOrEmailOrIdentifier(targetIdentifier: String): User
}