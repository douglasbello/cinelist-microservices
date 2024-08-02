package com.cinelits.ms.accounts.config

import com.cinelits.ms.accounts.handlers.RetrieveMessageErrorDecoder
import org.springframework.context.annotation.Bean

class FeignClientConfiguration {

    @Bean
    fun errorDecoder(): RetrieveMessageErrorDecoder {
        return RetrieveMessageErrorDecoder()
    }
}