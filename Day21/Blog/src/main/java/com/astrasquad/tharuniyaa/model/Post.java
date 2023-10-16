package com.astrasquad.tharuniyaa.model;





import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Table(name="_blogposts")
@Data
public class Post {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String date;
    private String author;
    private String content;
    private String imageUrl;

    // Add getters and setters here
}
