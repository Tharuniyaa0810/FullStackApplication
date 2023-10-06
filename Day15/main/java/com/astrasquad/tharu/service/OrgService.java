package com.astrasquad.tharu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.astrasquad.tharu.model.User;
import com.astrasquad.tharu.repository.OrgRepository;

@Service
public class OrgService {

    @Autowired
    private OrgRepository userRepository;

    public User createUser(User user) {
        // Implement logic to create a user and save it to the repository
        return userRepository.save(user);
    }

    public User getUserById(Integer userId) {
        // Implement logic to retrieve a user by ID from the repository
        return userRepository.findById(userId).orElse(null);
    }

    public void deleteUser(Integer userId) {
        // Implement logic to delete a user by ID from the repository
        userRepository.deleteById(userId);
    }
}
