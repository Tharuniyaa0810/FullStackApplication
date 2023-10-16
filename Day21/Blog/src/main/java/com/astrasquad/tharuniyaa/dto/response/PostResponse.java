package com.astrasquad.tharuniyaa.dto.response;
import lombok.Data;

@Data
public class PostResponse {
    private Long id;
    private String title;
    private String date;
    private String author;
    private String content;
    private String imageUrl;

    // Add getters and setters here
}