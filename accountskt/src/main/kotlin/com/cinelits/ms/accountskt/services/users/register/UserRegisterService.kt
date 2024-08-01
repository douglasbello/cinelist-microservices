package com.cinelits.ms.accountskt.services.users.register

import com.cinelits.ms.accountskt.database.models.User
import com.cinelits.ms.accountskt.dtos.users.UserRequest

interface UserRegisterService {
    fun save(request: UserRequest): User
}