package com.astrasquad.tharuniyaa.service;

import com.astrasquad.tharuniyaa.dto.request.AuthenticationRequest;
import com.astrasquad.tharuniyaa.dto.request.RegisterRequest;
import com.astrasquad.tharuniyaa.dto.response.AuthenticationResponse;

public interface AuthService {
    boolean userRegistration(RegisterRequest request);

    AuthenticationResponse userAuthentication(AuthenticationRequest request);
}

