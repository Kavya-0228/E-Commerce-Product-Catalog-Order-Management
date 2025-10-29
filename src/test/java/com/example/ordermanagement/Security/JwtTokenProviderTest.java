package com.example.ordermanagement.Security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JwtTokenProviderTest {

    private JwtTokenProvider tokenProvider;
    private static final String USERNAME = "testuser";

    @BeforeEach
    void setUp() {
        tokenProvider = new JwtTokenProvider();
    }

    @Test
    void generateTokenCreatesValidToken() {
        // Given a username
        // When generating a token
        String token = tokenProvider.generateToken(USERNAME);

        // Then token should be valid
        assertNotNull(token);
        assertTrue(tokenProvider.validateToken(token));
        assertEquals(USERNAME, tokenProvider.getUsernameFromToken(token));
    }

    @Test
    void validateTokenReturnsFalseForInvalidToken() {
        // Given an invalid token
        String invalidToken = "invalid.token.here";

        // When validating
        boolean isValid = tokenProvider.validateToken(invalidToken);

        // Then it should be invalid
        assertFalse(isValid);
    }

    @Test
    void getUsernameFromTokenReturnsCorrectUsername() {
        // Given a token for a user
        String token = tokenProvider.generateToken(USERNAME);

        // When extracting username
        String extractedUsername = tokenProvider.getUsernameFromToken(token);

        // Then username should match
        assertEquals(USERNAME, extractedUsername);
    }
}