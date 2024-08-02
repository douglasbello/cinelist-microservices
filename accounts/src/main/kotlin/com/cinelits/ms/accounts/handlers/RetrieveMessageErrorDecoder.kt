package com.cinelits.ms.accounts.handlers

import com.cinelits.ms.accounts.dtos.handlers.CustomErrorResponse
import com.cinelits.ms.accounts.handlers.exceptions.ResourceNotFoundException
import com.fasterxml.jackson.databind.ObjectMapper
import feign.Response
import feign.codec.ErrorDecoder
import org.apache.coyote.BadRequestException
import java.io.IOException

class RetrieveMessageErrorDecoder : ErrorDecoder {
    private val errorDecoder: ErrorDecoder = ErrorDecoder.Default()

    override fun decode(methodKey: String?, response: Response): Exception {
        val message: CustomErrorResponse? = try {
            response.body().asInputStream().use { bodyIs ->
                val mapper = ObjectMapper()
                mapper.readValue(bodyIs, CustomErrorResponse::class.java)
            }
        } catch (ex: IOException) {
            return Exception(ex.message)
        }

        return when (response.status()) {
            400 -> BadRequestException(message?.message ?: "Bad Request")
            404 -> ResourceNotFoundException(message?.message ?: "Resource Not Found")
            else -> errorDecoder.decode(methodKey, response)
        }
    }
}