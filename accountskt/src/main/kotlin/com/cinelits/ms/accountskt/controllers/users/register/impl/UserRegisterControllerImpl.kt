package com.cinelits.ms.accountskt.controllers.users.register.impl

import com.cinelits.ms.accountskt.controllers.users.register.UserRegisterController
import com.cinelits.ms.accountskt.database.models.User
import com.cinelits.ms.accountskt.dtos.users.UserRequest
import com.cinelits.ms.accountskt.services.users.register.UserRegisterService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserRegisterControllerImpl(
    private val userRegisterService: UserRegisterService
) : UserRegisterController {

    @PostMapping
    override fun save(@RequestBody request: UserRequest): ResponseEntity<User> {
        return ResponseEntity.ok().body(userRegisterService.save(request))
    }
}