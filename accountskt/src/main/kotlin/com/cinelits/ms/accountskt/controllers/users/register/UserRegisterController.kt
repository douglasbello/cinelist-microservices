package com.cinelits.ms.accountskt.controllers.users.register

import com.cinelits.ms.accountskt.database.models.User
import com.cinelits.ms.accountskt.dtos.users.UserRequest
import org.springframework.http.ResponseEntity

interface UserRegisterController {
    fun save(request: UserRequest): ResponseEntity<User>
}