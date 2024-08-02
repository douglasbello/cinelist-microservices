package com.cinelits.ms.accounts.services.users.register

import com.cinelits.ms.accounts.database.models.User
import com.cinelits.ms.accounts.dtos.users.UserRequest

interface UserRegisterService {
    fun save(request: UserRequest): User
}