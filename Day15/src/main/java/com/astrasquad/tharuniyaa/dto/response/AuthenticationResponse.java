package com.astrasquad.tharuniyaa.dto.response;




import com.astrasquad.tharuniyaa.model.enumerate.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {
    private String token;
    private String email;
    private Long uid;
    private String username;
    private Role role;
    private Long phone;    
  
}
