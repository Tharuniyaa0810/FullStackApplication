package com.astrasquad.tharu.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventRequestDTO {
    private String name;
    private Integer transaction;
    private String description;
    private List<String> images; // List of image URLs
    private UserDTO organizer; // Modify this line to use UserDTO
}