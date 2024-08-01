package com.cinelits.ms.accountskt.dtos.handlers

data class CustomErrorResponse(
    val message: String?,
    val status: String,
    val code: Int
) {
}