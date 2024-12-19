package org.khatep.smartrent.security.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.khatep.smartrent.security.dto.JwtAuthenticationResponse;
import org.khatep.smartrent.security.dto.SignInRequest;
import org.khatep.smartrent.security.dto.SignUpUserRequest;
import org.khatep.smartrent.security.service.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/sign-up")
    public ResponseEntity<JwtAuthenticationResponse> signUp(@RequestBody SignUpUserRequest request) {
        JwtAuthenticationResponse jwtAuthenticationResponse = authenticationService.signUpParent(request);
        log.info("new token registered: {}", jwtAuthenticationResponse.getToken());
        return ResponseEntity.status(HttpStatus.OK).body(jwtAuthenticationResponse);
    }

    @PostMapping("/sign-in")
    public JwtAuthenticationResponse signIn(@RequestBody SignInRequest request) {
        JwtAuthenticationResponse jwtAuthenticationResponse = authenticationService.signIn(request);
        log.info("new token registered: {}", jwtAuthenticationResponse.getToken());
        return authenticationService.signIn(request);
    }
}
