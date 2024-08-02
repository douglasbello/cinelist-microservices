package com.cinelits.ms.accounts

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication(exclude = [ SecurityAutoConfiguration::class ])
@EnableFeignClients
class AccountsktApplication

fun main(args: Array<String>) {
    runApplication<AccountsktApplication>(*args)
}
