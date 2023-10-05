package com.astrasquad.tharu.service;





import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.astrasquad.tharu.config.AuthenticationResponse;
import com.astrasquad.tharu.controller.AuthenticationRequest;
import com.astrasquad.tharu.controller.RegisterRequest;
import com.astrasquad.tharu.model.User;
import com.astrasquad.tharu.model.enumerated.Role;
import com.astrasquad.tharu.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.var;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final PasswordEncoder passwordEncoder; // Use final here as well.
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserRepository repo; // Use final to indicate this field should not be reassigned.
    public AuthenticationResponse register(RegisterRequest request) {
        var user =User.builder()
        		.firstname(request.getFirstname())
        		.lastname(request.getLastname())
        		.username(request.getUsername())
        		.password(passwordEncoder.encode(request.getPassword()))// Your code to save the user or perform other registration logic goes here.
        		.role(Role.USER)
        		.build();
        repo.save(user);
        var jwtToken=jwtService.generateToken(user);
        return AuthenticationResponse.builder()
        		.token(jwtToken)
        		.build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
      
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    request.getUsername(), request.getPassword()
                )
            );
            System.out.println("apply");
            var user = repo.findByUsername(request.getUsername())
                .orElseThrow();
            var jwtToken = jwtService.generateToken(user);
            return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
     
    }

}
