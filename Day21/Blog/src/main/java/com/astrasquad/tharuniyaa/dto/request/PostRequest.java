package com.astrasquad.tharuniyaa.dto.request;


import lombok.Data;

@Data
public class PostRequest {
    private String title;
    private String date;
    private String author;
    private String content;
    private String imageUrl;

    // Add getters and setters here
}

