package com.astrasquad.tharuniyaa.service.impl;
import java.util.List;
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
        User newUser = new User();
        if (user != null) {
            newUser = User.builder()
                    .username(request.getUsername())
                    .email(request.getEmail())
                    .password(request.getPassword())
                    .role(request.getRole())
                    .phone(request.getPhone())
                    .build();
            userRepository.save(newUser);
        }
        return mapUserToUserResponse(newUser);
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

    private UserResponse mapUserToUserResponse(User user) {
        return UserResponse.builder()
                .uid(user.getUid())
                .username(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole())
                .phone(user.getPhone())
                .build();
    }

    @Override
    public CountResponse userCount() {
        long count = userRepository.count();
        return CountResponse.builder().count(count).build();
    }

}
