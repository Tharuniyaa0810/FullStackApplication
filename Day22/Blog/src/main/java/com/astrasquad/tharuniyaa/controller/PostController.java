package com.astrasquad.tharuniyaa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.astrasquad.tharuniyaa.dto.request.PostRequest;
import com.astrasquad.tharuniyaa.dto.response.PostResponse;
import com.astrasquad.tharuniyaa.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<PostResponse> getAllPosts() {
        return postService.getAllPosts();
    }

    @PostMapping
    public PostResponse createPost(@RequestBody PostRequest postRequest) {
        return postService.createPost(postRequest);
    }

    // Add other methods as needed
}
