package com.cinelits.ms.accountskt.services.users.search.impl

import com.cinelits.ms.accountskt.database.models.User
import com.cinelits.ms.accountskt.database.repositories.UserRepository
import com.cinelits.ms.accountskt.handlers.exceptions.ResourceNotFoundException
import com.cinelits.ms.accountskt.services.users.search.UserSearchService
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