package com.cinelits.ms.accounts.handlers

import com.cinelits.ms.accounts.dtos.handlers.FeignErrorResponse
import com.cinelits.ms.accounts.handlers.exceptions.ResourceNotFoundException
import com.fasterxml.jackson.databind.ObjectMapper
import feign.Response
import feign.codec.ErrorDecoder
import org.apache.coyote.BadRequestException
import java.io.IOException

class RetrieveMessageErrorDecoder : ErrorDecoder {
    private val errorDecoder: ErrorDecoder = ErrorDecoder.Default()

    override fun decode(methodKey: String?, response: Response): Exception {
        val message: FeignErrorResponse? = try {
            response.body().asInputStream().use { bodyIs ->
                val mapper = ObjectMapper()
                mapper.readValue(bodyIs, FeignErrorResponse::class.java)
            }
        } catch (ex: IOException) {
            return Exception(ex.message)
        }

        return when (response.status()) {
            400 -> BadRequestException(message?.error ?: "Bad Request")
            404 -> ResourceNotFoundException(message?.error ?: "Movie Not Found")
            else -> errorDecoder.decode(methodKey, response)
        }
    }
}