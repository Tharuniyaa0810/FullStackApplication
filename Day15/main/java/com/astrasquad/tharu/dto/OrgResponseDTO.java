package com.astrasquad.tharu.dto;

import com.astrasquad.tharu.controller.RegisterRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrgResponseDTO {
    private Integer id;
    private String name;
    private String type;
}
