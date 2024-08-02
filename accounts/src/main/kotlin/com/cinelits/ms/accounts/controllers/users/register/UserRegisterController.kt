package com.cinelits.ms.accounts.controllers.users.register

import com.cinelits.ms.accounts.database.models.User
import com.cinelits.ms.accounts.dtos.users.UserRequest
import org.springframework.http.ResponseEntity

interface UserRegisterController {
    fun save(request: UserRequest): ResponseEntity<User>
}