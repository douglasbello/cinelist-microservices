package com.cinelits.ms.accountskt.dtos.users

import com.cinelits.ms.accountskt.database.models.User
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

