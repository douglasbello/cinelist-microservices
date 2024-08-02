package com.cinelits.ms.accountskt.config

import com.cinelits.ms.accountskt.handlers.RetrieveMessageErrorDecoder
import org.springframework.context.annotation.Bean

class FeignClientConfiguration {

    @Bean
    fun errorDecoder(): RetrieveMessageErrorDecoder {
        return RetrieveMessageErrorDecoder()
    }
}