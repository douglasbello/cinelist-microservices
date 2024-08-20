package com.cinelist.ms.authentication.services.auth;

import com.cinelist.ms.authentication.configuration.security.TokenProvider;
import com.cinelist.ms.authentication.database.models.User;
import com.cinelist.ms.authentication.dto.auth.LoginRequest;
import com.cinelist.ms.authentication.dto.auth.TokenResponse;
import com.cinelist.ms.authentication.services.user.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final TokenProvider tokenProvider;
    private final UserService userService;

    public AuthenticationService(AuthenticationManager authenticationManager, TokenProvider tokenProvider, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
        this.userService = userService;
    }

    public TokenResponse authenticate(final LoginRequest request) throws Exception {
        try {
            Authentication authentication = authenticationManager.authenticate(request.build());
            User user = tokenProvider.getUser(authentication);

            TokenResponse response = new TokenResponse(user.)
        }
    }
}