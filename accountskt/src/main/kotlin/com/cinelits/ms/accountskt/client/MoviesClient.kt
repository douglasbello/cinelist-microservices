package com.cinelits.ms.accountskt.client

import com.cinelits.ms.accountskt.config.FeignClientConfiguration
import com.cinelits.ms.accountskt.dtos.client.MovieResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import java.util.UUID

@FeignClient(value = "moviesClient", url = "http://localhost:8082", configuration = [FeignClientConfiguration::class])
interface MoviesClient {
    @RequestMapping(method = [RequestMethod.GET], value = ["/movies/{identifier}"])
    fun findByIdentifier(@PathVariable identifier: UUID): ResponseEntity<MovieResponse>
}