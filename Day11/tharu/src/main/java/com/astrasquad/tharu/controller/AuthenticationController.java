package com.astrasquad.tharu.controller;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.astrasquad.tharu.config.AuthenticationResponse;
import com.astrasquad.tharu.service.AuthenticationService;

import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
	private final AuthenticationService service;
@PostMapping("/register")
public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request)
{
	return ResponseEntity.ok(service.register(request));
}
@PostMapping("/authenticate")
public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) throws Exception
{
	return ResponseEntity.ok(service.authenticate(request));
}

}