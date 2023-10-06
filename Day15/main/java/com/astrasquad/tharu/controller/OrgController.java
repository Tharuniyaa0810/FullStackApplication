package com.astrasquad.tharu.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.astrasquad.tharu.dto.OrgRequestDTO;
import com.astrasquad.tharu.dto.OrgResponseDTO;
import com.astrasquad.tharu.model.User;
import com.astrasquad.tharu.service.OrgService;

@RestController
@RequestMapping("/org")
public class OrgController {

    @Autowired
    private OrgService userService;


    @GetMapping("/{userId}")
    public ResponseEntity<OrgResponseDTO> getUser(@PathVariable Integer userId) {
        // Call the service layer to retrieve the user by ID
        User user = userService.getUserById(userId);

        // Map the user entity to the response DTO within the controller method
        OrgResponseDTO responseDTO = new OrgResponseDTO();
        responseDTO.setId(user.getOrgID());
        responseDTO.setName(user.getName());
        responseDTO.setType(user.getType());

        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer userId) {
        // Call the service layer to delete the user by ID
        userService.deleteUser(userId);

        return ResponseEntity.noContent().build();
    }
}
