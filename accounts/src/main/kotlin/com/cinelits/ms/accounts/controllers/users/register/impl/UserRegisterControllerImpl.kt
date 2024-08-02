package com.cinelits.ms.accounts.controllers.users.register.impl

import com.cinelits.ms.accounts.client.MoviesClient
import com.cinelits.ms.accounts.controllers.users.register.UserRegisterController
import com.cinelits.ms.accounts.database.models.User
import com.cinelits.ms.accounts.dtos.client.MovieResponse
import com.cinelits.ms.accounts.dtos.users.UserRequest
import com.cinelits.ms.accounts.services.users.register.UserRegisterService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/users")
class UserRegisterControllerImpl(
    private val userRegisterService: UserRegisterService,
    private val moviesClient: MoviesClient
) : UserRegisterController {

    @PostMapping
    override fun save(@RequestBody request: UserRequest): ResponseEntity<User> {
        return ResponseEntity.ok().body(userRegisterService.save(request))
    }

    @GetMapping("/movie/{identifier}")
    fun testing(@PathVariable identifier: UUID): ResponseEntity<MovieResponse> {
        return moviesClient.findByIdentifier(identifier)
    }
}