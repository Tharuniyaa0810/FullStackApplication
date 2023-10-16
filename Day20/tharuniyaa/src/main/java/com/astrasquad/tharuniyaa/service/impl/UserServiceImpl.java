package com.astrasquad.tharuniyaa.service.impl;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.astrasquad.tharuniyaa.dto.request.UserRequest;
import com.astrasquad.tharuniyaa.dto.response.CountResponse;
import com.astrasquad.tharuniyaa.dto.response.UserResponse;
import com.astrasquad.tharuniyaa.model.User;
import com.astrasquad.tharuniyaa.model.enumerate.Role;
import com.astrasquad.tharuniyaa.repository.UserRepository;
import com.astrasquad.tharuniyaa.service.UserService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
   
    @Override
    public List<UserResponse> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return userList.stream()
                .filter(user -> !user.getRole().equals(Role.ADMIN))
                .map(this::mapUserToUserResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse getUser(Long uid) {
        User user = userRepository.findByUid(uid);
        return mapUserToUserResponse(user);
    }

    @Override
    public UserResponse updateUser(UserRequest request, Long uid) {
        User user = userRepository.findByUid(uid);
      
        if (user != null) {
            user.setUsername(request.getUsername());
            user.setEmail(request.getEmail());
            user.setPassword(request.getPassword());
            user.setAddress(request.getAddress());
            user.setRole(request.getRole());
            user.setPhone(request.getPhone());
            userRepository.save(user);
        }
        return mapUserToUserResponse(user);
    }


    @Override
    public boolean deleteProduct(Long uid) {
        User user = userRepository.findByUid(uid);

        if (user != null) {
           
            userRepository.deleteByUid(uid);
            return true;
        } else {
            return false;
        }
    }
    public User getUserByUsername(String username) {
        // Assuming you have a repository named userRepository that handles user data
        Optional<User> userOptional = userRepository.findByUsername(username);

        if (userOptional.isPresent()) {
            return userOptional.get(); // Return the user if found
        } else {
            // Handle the case when the user is not found
            throw new IllegalArgumentException("User not found for the provided username");
        }
    }

    private UserResponse mapUserToUserResponse(User user) {
        return UserResponse.builder()
                .uid(user.getUid())
                .username(user.getUsername())
                .email(user.getEmail())
                .address(user.getAddress())
                .role(user.getRole())
                .phone(user.getPhone())
                .build();
    }

    @Override
    public CountResponse userCount() {
        long count = userRepository.count();
        return CountResponse.builder().count(count).build();
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        return userOptional.orElse(null);
    }
	

}
