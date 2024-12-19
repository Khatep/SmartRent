package org.khatep.smartrent.security.service;


import lombok.RequiredArgsConstructor;
import org.khatep.smartrent.domain.models.User;
import org.khatep.smartrent.security.dto.JwtAuthenticationResponse;
import org.khatep.smartrent.security.dto.SignInRequest;
import org.khatep.smartrent.security.dto.SignUpUserRequest;
import org.khatep.smartrent.services.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    /**
     * Parent registration
     *
     * @param request data of parent
     * @return {@link JwtAuthenticationResponse} which contain token
     */
    public JwtAuthenticationResponse signUpParent(SignUpUserRequest request) {

        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();

        userService.save(user);

        var jwt = jwtService.generateToken(user);
        return new JwtAuthenticationResponse(jwt);
    }

    /**
     * Auth of all types of users
     *
     * @param request data of user
     * @return {@link JwtAuthenticationResponse} which contain token
     */
    public JwtAuthenticationResponse signIn(SignInRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        ));

        String jwt = null;
        var user = userService
                    .userDetailsService()
                    .loadUserByUsername(request.getUsername());
        jwt = jwtService.generateToken(user);

        return new JwtAuthenticationResponse(jwt);
    }
}