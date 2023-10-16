package com.astrasquad.tharuniyaa.service.impl;



import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.astrasquad.tharuniyaa.dto.request.AuthenticationRequest;
import com.astrasquad.tharuniyaa.dto.request.RegisterRequest;
import com.astrasquad.tharuniyaa.dto.response.AuthenticationResponse;
import com.astrasquad.tharuniyaa.model.User;
import com.astrasquad.tharuniyaa.model.enumerate.Role;
import com.astrasquad.tharuniyaa.repository.UserRepository;
import com.astrasquad.tharuniyaa.service.AuthService;
import com.astrasquad.tharuniyaa.util.JwtUtil;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @Override
    public boolean userRegistration(RegisterRequest request) {
        Optional<User> isUserExists = userRepository.findByUsername(request.getUsername());
        if (!isUserExists.isPresent()) {
            var user = User.builder()
                    .username(request.getUsername())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .address(request.getAddress())
                    .isEnabled(true)
                    .role(Role.CUSTOMER)
                    .phone(request.getPhone())
                    .build();
            userRepository.save(user);
            return true;
        } else {
            return false;
        }
    }

    public AuthenticationResponse userAuthentication(AuthenticationRequest request) {
    	System.out.println("Received request with username: " + request.getUsername());
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        var user = userRepository.findByUsername(request.getUsername()).orElseThrow(() -> new UsernameNotFoundException("User not found for username: " + request.getUsername()));
        var token = jwtUtil.generateToken(user);
        return AuthenticationResponse.builder()
                .token(token)
                .uid(user.getUid())
                .email(user.getEmail())
                .username(user.getUsername())
                .address(user.getAddress())
                .role(user.getRole())
                .phone(user.getPhone())
                .build();
    }


}
