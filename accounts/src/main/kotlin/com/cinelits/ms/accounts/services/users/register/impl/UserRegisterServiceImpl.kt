package com.cinelits.ms.accounts.services.users.register.impl

import com.cinelits.ms.accounts.database.models.User
import com.cinelits.ms.accounts.database.repositories.UserRepository
import com.cinelits.ms.accounts.dtos.users.UserRequest
import com.cinelits.ms.accounts.handlers.exceptions.UniqueConstraintException
import com.cinelits.ms.accounts.services.users.register.UserRegisterService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserRegisterServiceImpl(
    val userRepository: UserRepository,
) : UserRegisterService {

    val passwordEncoder: PasswordEncoder = BCryptPasswordEncoder()

    override fun save(userRequest: UserRequest): User {
        val usernameAlreadyExists = userRepository.findByUsername(userRequest.username)
        if (!usernameAlreadyExists.isEmpty)
            throw UniqueConstraintException("Username already in use.")

        val emailAlreadyExists = userRepository.findByEmail(userRequest.email)
        if (!emailAlreadyExists.isEmpty)
            throw UniqueConstraintException("Email already in use.")

        var user: User = userRequest.toEntity()
        user.password = passwordEncoder.encode(user.password)

        return userRepository.save(user)
    }

    private fun UserRequest.toEntity() = User(
        firstName = firstName,
        lastName = lastName,
        username = username,
        email = email,
        password = password,
        biography = biography,
        birthDate = birthDate,
        location = location,
        photoUrl = photoUrl
    )
}