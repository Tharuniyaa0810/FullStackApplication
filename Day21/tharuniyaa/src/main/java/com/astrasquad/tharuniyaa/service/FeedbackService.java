package com.astrasquad.tharuniyaa.service;

import com.astrasquad.tharuniyaa.dto.request.FeedbackRequest;
import com.astrasquad.tharuniyaa.dto.response.FeedbackResponse;

import java.util.List;

public interface FeedbackService {

    FeedbackResponse createFeedback(FeedbackRequest feedbackRequest);

    FeedbackResponse getFeedbackById(Long id);

    List<FeedbackResponse> getAllFeedbacks();

    FeedbackResponse updateFeedback(Long id, FeedbackRequest feedbackRequest);

    void deleteFeedback(Long id);
}
