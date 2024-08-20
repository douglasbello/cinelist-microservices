package com.cinelist.ms.authentication.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "redis")
public class RedisProperties {
    private String host;
    private int port;
    private String pass;
}