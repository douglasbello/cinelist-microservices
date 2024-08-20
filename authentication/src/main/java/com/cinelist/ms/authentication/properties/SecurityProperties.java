package com.cinelist.ms.authentication.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "security")
public class SecurityProperties {
    private String jwtKey;

    public SecurityProperties() {
    }

    public SecurityProperties(String jwtKey) {
        this.jwtKey = jwtKey;
    }

    public String getJwtKey() {
        return jwtKey;
    }

    public void setJwtKey(String jwtKey) {
        this.jwtKey = jwtKey;
    }
}