package com.astrasquad.tharuniyaa.service;


import java.util.List;
import java.util.Optional;

import com.astrasquad.tharuniyaa.dto.request.PostRequest;
import com.astrasquad.tharuniyaa.dto.response.PostResponse;
import com.astrasquad.tharuniyaa.model.Post;

public interface PostService {
   

    

   


	PostResponse createPost(PostRequest postRequest);

	List<PostResponse> getAllPosts();

	

   
}

