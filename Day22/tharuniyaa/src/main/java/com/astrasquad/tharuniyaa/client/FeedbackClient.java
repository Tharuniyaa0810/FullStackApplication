package com.astrasquad.tharuniyaa.client;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.astrasquad.tharuniyaa.vo.Feedback;



@FeignClient(name = "FEEDBACK", url = "${application.config.feedback-service.url}")
public interface FeedbackClient {

    @PostMapping("/add")
    boolean saveFeedback(@RequestBody com.astrasquad.tharuniyaa.dto.request.FeedbackRequest request);

    @GetMapping("/get")
    List<Feedback> getFeedbacks();
}

