package com.cinelits.ms.accountskt.handlers.exceptions

class ResourceNotFoundException(message: String = "Resource not found.") : RuntimeException(message) {
    companion object {
        private const val serialVersionUID = 1L
    }
}