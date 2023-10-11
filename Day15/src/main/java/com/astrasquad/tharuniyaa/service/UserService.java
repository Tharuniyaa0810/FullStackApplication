package com.astrasquad.tharuniyaa.service;


import java.util.List;

import com.astrasquad.tharuniyaa.dto.request.UserRequest;
import com.astrasquad.tharuniyaa.dto.response.CountResponse;
import com.astrasquad.tharuniyaa.dto.response.UserResponse;



public interface UserService {

    List<UserResponse> getAllUsers();

    UserResponse getUser(Long uid);

    UserResponse updateUser(UserRequest request, Long uid);

    boolean deleteProduct(Long uid);

    CountResponse userCount();

}
