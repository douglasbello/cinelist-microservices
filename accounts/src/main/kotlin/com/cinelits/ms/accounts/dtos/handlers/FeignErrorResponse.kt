package com.cinelits.ms.accounts.dtos.handlers

import com.fasterxml.jackson.annotation.JsonProperty

data class FeignErrorResponse(
    @JsonProperty("error") val error: String,
    @JsonProperty("status") val status: String,
    @JsonProperty("code") val code: Int
)