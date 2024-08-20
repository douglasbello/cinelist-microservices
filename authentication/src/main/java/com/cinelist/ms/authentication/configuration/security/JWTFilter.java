package com.cinelist.ms.authentication.configuration.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

public class JWTFilter extends GenericFilterBean {
    public static final String AUTHORIZATION_HEADER = "Authorization";
    private final TokenProvider tokenProvider;

    public JWTFilter(TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String jwt = httpServletRequest.getHeader(AUTHORIZATION_HEADER);

        if (!StringUtils.hasText(jwt)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        } else if (StringUtils.hasText(jwt) && this.tokenProvider.isValid(jwt, servletResponse)) {
            final String userIdentifier = tokenProvider.getIdentifierFromToken(jwt);

            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userIdentifier, null, null);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } else {
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}