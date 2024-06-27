package com.celk.crud_paciente.adapter.in.controller;

import com.celk.crud_paciente.adapter.in.controller.request.LoginRequest;
import com.celk.crud_paciente.adapter.out.repository.UserRepository;
import com.celk.crud_paciente.adapter.out.repository.entity.UserAuthenticated;
import com.celk.crud_paciente.adapter.out.repository.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/login")
@AllArgsConstructor
public class LoginController {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    private AuthenticationManager authenticationManager;

    private JwtEncoder encoder;

    @PostMapping
    public String login(@RequestBody LoginRequest loginRequest) {

        var user = userRepository.findByUsername(loginRequest.username());

        if (user.isEmpty() || !verifyPassword(loginRequest.password(), user.get().getPassword())) {
            throw new BadCredentialsException("Username or password is invalid");
        }

        UsernamePasswordAuthenticationToken userAuth = new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password());
        Authentication authentication = authenticationManager.authenticate(userAuth);

        UserAuthenticated userAuthenticated = (UserAuthenticated) authentication.getPrincipal();


        return generateToken(userAuthenticated);
    }

    public boolean verifyPassword(String password, String passwordEncrypted) {
        return passwordEncoder.matches(password, passwordEncrypted);
    }

    public String generateToken(UserAuthenticated userAuthenticated) {
        long expire = 3600L;

        String roles = userAuthenticated.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .map(role -> "ROLE_" + role)
                .collect(Collectors.joining(" "));

        var claims = JwtClaimsSet.builder()
                .issuer("spring-security-jwt")
                .issuedAt(Instant.now())
                .expiresAt(Instant.now().plusSeconds(expire))
                .subject(userAuthenticated.getUsername())
                .claim("roles", roles)
                .build();

        return encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

}
