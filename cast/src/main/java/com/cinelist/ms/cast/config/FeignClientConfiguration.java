package com.cinelist.ms.cast.config;

import com.cinelist.ms.cast.handlers.RetrieveMessageErrorDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class FeignClientConfiguration {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new RetrieveMessageErrorDecoder();
    }
}