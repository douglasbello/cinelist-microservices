package com.cinelits.ms.accounts.handlers.exceptions

class UniqueConstraintException(message: String) : RuntimeException(message) {
    companion object {
        private const val serialVersionUID = 1L
    }
}
