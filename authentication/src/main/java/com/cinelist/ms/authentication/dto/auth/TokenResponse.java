package com.cinelist.ms.authentication.dto.auth;

public class TokenResponse {
    private String token;
    private Long expiresIn;
    private String username;

    public TokenResponse() {
    }

    public TokenResponse(String token, Long expiresIn, String username) {
        this.token = token;
        this.expiresIn = expiresIn;
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}