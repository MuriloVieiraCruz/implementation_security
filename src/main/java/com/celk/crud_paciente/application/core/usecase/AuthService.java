package com.celk.crud_paciente.application.core.usecase;

import com.celk.crud_paciente.adapter.in.controller.request.AuthRequest;
import com.celk.crud_paciente.adapter.out.repository.UserRepository;
import com.celk.crud_paciente.config.security.TokenDTO;
import com.celk.crud_paciente.config.security.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.server.resource.authentication.BearerTokenAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationProvider;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenGenerator tokenGenerator;

    @Autowired
    @Qualifier("jwtRefreshTokenAuthenticationProvider")
    private JwtAuthenticationProvider refreshTokenAuthProvider;

    public TokenDTO login(AuthRequest authRequest) {
        var user = userRepository.findByUsername(authRequest.username());

        if (user.isEmpty() || !verifyPassword(authRequest.password(), user.get().getPassword())) {
            throw new BadCredentialsException("Username or password is invalid");
        }

        Authentication authentication = new UsernamePasswordAuthenticationToken(authRequest.username(), authRequest.password());
        return tokenGenerator.createToken(authentication);
    }

    private boolean verifyPassword(String password, String passwordEncrypted) {
        return passwordEncoder.matches(password, passwordEncrypted);
    }

    public TokenDTO token(TokenDTO tokenDTO) {
        Authentication authentication = refreshTokenAuthProvider.authenticate(new BearerTokenAuthenticationToken(tokenDTO.getRefreshToken()));
        return tokenGenerator.createToken(authentication);
    }
}
