package com.cinelits.ms.accounts.services.users.search.impl

import com.cinelits.ms.accounts.database.models.User
import com.cinelits.ms.accounts.database.repositories.UserRepository
import com.cinelits.ms.accounts.handlers.exceptions.ResourceNotFoundException
import com.cinelits.ms.accounts.services.users.search.UserSearchService
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserSearchServiceImpl(
    val userRepository: UserRepository,
) : UserSearchService {

    override fun findByUsernameOrEmailOrIdentifier(targetIdentifier: String): User {
        var user: Optional<User>

        user = userRepository.findByUsername(targetIdentifier)
        if (user.isEmpty())
            user = userRepository.findByEmail(targetIdentifier)
        if (user.isEmpty())
            user = userRepository.findByIdentifier(UUID.fromString(targetIdentifier))
        if (user.isEmpty())
            throw ResourceNotFoundException()

        return user.get()
    }
}