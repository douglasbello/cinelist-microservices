package com.cinelits.ms.accounts.dtos.users

import java.time.LocalDate

data class UserRequest(val firstName: String?,
                  val lastName: String?,
                  val username: String?,
                  val email: String?,
                  val password: String?,
                  val biography: String?,
                  val location: String?,
                  val photoUrl: String?,
                  val birthDate: LocalDate?
)

