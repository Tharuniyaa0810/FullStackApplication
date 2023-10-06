package com.astrasquad.tharu.service;

import org.springframework.stereotype.Service;

import com.astrasquad.tharu.dto.UserResponseDto;

@Service
public interface UserService {

    UserResponseDto getAllUser();

}
