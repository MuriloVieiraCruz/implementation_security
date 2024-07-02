package com.celk.crud_paciente.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;

@Component
public class TokenGenerator {

    @Autowired
    private JwtEncoder accessTokenEncoder;

    @Autowired
    @Qualifier("jwtRefreshEncoder")
    private JwtEncoder refreshTokenEncoder;

    private String generateToken(Authentication userAuthenticated, long durationMinutes, JwtEncoder encoder) {
        Instant now = Instant.now();

        String roles = userAuthenticated.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .map(role -> "ROLE_" + role)
                .collect(Collectors.joining(" "));

        var claims = JwtClaimsSet.builder()
                .issuer("spring-security-jwt")
                .issuedAt(now)
                .expiresAt(now.plus(durationMinutes, ChronoUnit.MINUTES))
                .subject(userAuthenticated.getName())
                .claim("roles", roles)
                .build();

        return encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

    public TokenDTO createToken(Authentication userAuthenticated) {
        TokenDTO token = new TokenDTO();
        token.setUsername(userAuthenticated.getName());
        token.setAccessToken(generateAccessToken(userAuthenticated));

        token.setRefreshToken(determineRefreshToken(userAuthenticated));

        return token;
    }

    private String determineRefreshToken(Authentication userAuthenticated) {
        if (userAuthenticated.getCredentials() instanceof Jwt jwt) {
            return handleJwtRefreshToken(jwt, userAuthenticated);
        } else {
            return generateRefreshToken(userAuthenticated);
        }
    }

    private String handleJwtRefreshToken(Jwt jwt, Authentication userAuthenticated) {
        Instant now = Instant.now();
        Instant expiresAt = jwt.getExpiresAt();
        long daysToExpire = Duration.between(now, expiresAt).toDays();

        if (daysToExpire >= 7) {
            return generateRefreshToken(userAuthenticated);
        } else {
            return jwt.getTokenValue();
        }
    }

    private String generateAccessToken(Authentication userAuthenticated) {
        return generateToken(userAuthenticated, 5, accessTokenEncoder);
    }

    private String generateRefreshToken(Authentication userAuthenticated) {
        return generateToken(userAuthenticated, 30, refreshTokenEncoder);
    }
}
