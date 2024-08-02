package com.cinelits.ms.accounts.controllers.users.search.impl

import com.cinelits.ms.accounts.controllers.users.search.UserSearchController
import com.cinelits.ms.accounts.database.models.User
import com.cinelits.ms.accounts.services.users.search.UserSearchService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserSearchControllerImpl(
    private val userSearchService: UserSearchService
) : UserSearchController {

    @GetMapping("/{targetIdentifier}")
    override fun findByUsernameOrByEmailOrByIdentifier(@PathVariable targetIdentifier: String): ResponseEntity<User> {
        return ResponseEntity.ok().body(userSearchService.findByUsernameOrEmailOrIdentifier(targetIdentifier.toString()))
    }
}