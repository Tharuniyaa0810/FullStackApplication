package com.astrasquad.tharuniyaa.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.astrasquad.tharuniyaa.dto.request.PostRequest;
import com.astrasquad.tharuniyaa.dto.response.PostResponse;
import com.astrasquad.tharuniyaa.model.Post;
import com.astrasquad.tharuniyaa.repository.PostRepository;
import com.astrasquad.tharuniyaa.service.PostService;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<PostResponse> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return convertToPostResponseList(posts);
    }

    @Override
    public PostResponse createPost(PostRequest postRequest) {
        Post post = convertToPost(postRequest);
        post = postRepository.save(post);
        return convertToPostResponse(post);
    }

    private PostResponse convertToPostResponse(Post post) {
        PostResponse postResponse = new PostResponse();
        postResponse.setId(post.getId());
        postResponse.setTitle(post.getTitle());
        postResponse.setDate(post.getDate());
        postResponse.setAuthor(post.getAuthor());
        postResponse.setContent(post.getContent());
        postResponse.setImageUrl(post.getImageUrl());
        return postResponse;
    }

    private List<PostResponse> convertToPostResponseList(List<Post> posts) {
        return posts.stream().map(this::convertToPostResponse).collect(Collectors.toList());
    }

    private Post convertToPost(PostRequest postRequest) {
        Post post = new Post();
        post.setTitle(postRequest.getTitle());
        post.setDate(postRequest.getDate());
        post.setAuthor(postRequest.getAuthor());
        post.setContent(postRequest.getContent());
        post.setImageUrl(postRequest.getImageUrl());
        return post;
    }
}
	