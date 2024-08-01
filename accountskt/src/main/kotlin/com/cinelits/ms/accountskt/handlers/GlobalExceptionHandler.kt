package com.cinelits.ms.accountskt.handlers

import com.cinelits.ms.accountskt.dtos.handlers.CustomErrorResponse
import com.cinelits.ms.accountskt.handlers.exceptions.ResourceNotFoundException
import com.cinelits.ms.accountskt.handlers.exceptions.UniqueConstraintException
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleResourceNotFoundException(ex: ResourceNotFoundException): ResponseEntity<CustomErrorResponse> {
        var error = CustomErrorResponse(ex.message, HttpStatus.NOT_FOUND.reasonPhrase, HttpStatus.NOT_FOUND.value())

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error)
    }

    @ExceptionHandler(DataIntegrityViolationException::class)
    fun handleDataIntegrityViolationException(ex: DataIntegrityViolationException): ResponseEntity<CustomErrorResponse> {
        var error = CustomErrorResponse(ex.message, HttpStatus.BAD_REQUEST.reasonPhrase, HttpStatus.BAD_REQUEST.value())

        return ResponseEntity.badRequest().body(error)
    }

    @ExceptionHandler(UniqueConstraintException::class)
    fun uniqueConstraintException(ex: UniqueConstraintException): ResponseEntity<CustomErrorResponse> {
        var error = CustomErrorResponse(ex.message, HttpStatus.BAD_REQUEST.reasonPhrase, HttpStatus.BAD_REQUEST.value())

        return ResponseEntity.badRequest().body(error)
    }
}