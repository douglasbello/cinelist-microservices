package com.cinelits.ms.accountskt.services.users.search

import com.cinelits.ms.accountskt.database.models.User

interface UserSearchService {
    fun findByUsernameOrEmailOrIdentifier(targetIdentifier: String): User
}