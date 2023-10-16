package com.astrasquad.tharuniyaa.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.astrasquad.tharuniyaa.dto.request.PostRequest;
import com.astrasquad.tharuniyaa.vo.Post;



@FeignClient(name = "BLOG", url = "${application.config.blog-service.url}")
@RequestMapping("/posts")
public interface PostClient {

    @PostMapping
    boolean createPost(@RequestBody PostRequest request);

    @GetMapping
    List<Post> getAllPosts();
}