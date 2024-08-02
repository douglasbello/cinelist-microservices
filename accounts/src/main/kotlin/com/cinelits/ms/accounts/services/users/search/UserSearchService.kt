package com.cinelits.ms.accounts.services.users.search

import com.cinelits.ms.accounts.database.models.User

interface UserSearchService {
    fun findByUsernameOrEmailOrIdentifier(targetIdentifier: String): User
}