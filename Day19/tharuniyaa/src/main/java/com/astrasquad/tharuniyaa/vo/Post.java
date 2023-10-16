package com.astrasquad.tharuniyaa.vo;



import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Post {
    @Id
    private Long id;
    private String title;
    private String date;
    private String author;
    private String content;
    private String imageUrl;

    // Add getters and setters here
}

