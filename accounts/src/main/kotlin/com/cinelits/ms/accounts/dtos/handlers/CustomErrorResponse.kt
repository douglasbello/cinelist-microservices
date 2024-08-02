package com.cinelits.ms.accounts.dtos.handlers

data class CustomErrorResponse(
    val message: String?,
    val status: String,
    val code: Int
) {
}