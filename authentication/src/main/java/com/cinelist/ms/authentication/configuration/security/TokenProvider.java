package com.cinelist.ms.authentication.configuration.security;

import com.cinelist.ms.authentication.database.models.User;
import com.cinelist.ms.authentication.dto.auth.TokenResponse;
import com.cinelist.ms.authentication.properties.SecurityProperties;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.SignedJWT;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.ServletRegistration;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class TokenProvider {
    public static final String AUTH = "AUTH_";
    private static final int EXPIRATION_TIME = 86400000;
    private static final int UNAUTHORIZED = 401;
    private static final int EXPIRED = 440;
    private static final String ISSUER = "Web Token";
    private final SecurityProperties securityProperties;

    public TokenProvider(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }

    public TokenResponse generateToken(Authentication authentication) {
        String secret = securityProperties.getJwtKey();

        final Date now = new Date();
        long expirationInMillis = EXPIRATION_TIME;
        Date exp = new Date(System.currentTimeMillis() + expirationInMillis);

        final User user = getUser(authentication);

        final String auth = Jwts.builder()
                .setIssuer(ISSUER)
                .setSubject(user.getIdentifier().toString())
                .setIssuedAt(now)
                .setNotBefore(now)
                .setExpiration(exp)
                .signWith(SignatureAlgorithm.HS256, secret.getBytes(StandardCharsets.UTF_8))
                .compact();

        return new TokenResponse(auth, expirationInMillis, user.getUsername());
    }

    public Boolean isValid(String jwt, ServletResponse response) throws IOException {
        try {
            jwt = extractToken(jwt);
            String secret = securityProperties.getJwtKey();

            SignedJWT signedJWT = SignedJWT.parse(jwt);
            JWSVerifier verifier = new MACVerifier(securityProperties.getJwtKey().getBytes(StandardCharsets.UTF_8));
            if (!signedJWT.verify(verifier)) {
                ((HttpServletResponse) response).sendError(UNAUTHORIZED);

                return false;
            }
            Jwts.parser().setSigningKey(secret.getBytes(StandardCharsets.UTF_8)).parseClaimsJws(jwt).getBody();
            return true;
        } catch (ExpiredJwtException ex) {
            ((HttpServletResponse) response).sendError(EXPIRED);
            return false;
        } catch (Exception ex) {
            ((HttpServletResponse) response).sendError(UNAUTHORIZED);
            return false;
        }
    }

    public String getIdentifierFromToken(String jwt) {
        jwt = extractToken(jwt);
        String secret = securityProperties.getJwtKey();
        Claims claims = Jwts.parser().setSigningKey(secret.getBytes(StandardCharsets.UTF_8)).parseClaimsJws(jwt).getBody();

        return claims.getSubject();
    }

    public User getUser(Authentication authentication) {
        return (User) authentication.getPrincipal();
    }

    private String extractToken(String authToken) {
        if (authToken.toLowerCase().startsWith("bearer"))
            return authToken.substring("bearer".length());

        return authToken;
    }
}