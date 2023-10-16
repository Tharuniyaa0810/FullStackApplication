package com.astrasquad.tharuniyaa.dto.request;



import com.astrasquad.tharuniyaa.model.enumerate.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
	   private String username;
	    private String email;
	    private String password;
	    private Role role;
	    private Long phone; 
	    private String address;
}
