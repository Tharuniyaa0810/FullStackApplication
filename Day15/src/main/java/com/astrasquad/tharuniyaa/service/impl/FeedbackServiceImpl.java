package com.astrasquad.tharuniyaa.service.impl;

import com.astrasquad.tharuniyaa.dto.request.FeedbackRequest;
import com.astrasquad.tharuniyaa.dto.response.FeedbackResponse;
import com.astrasquad.tharuniyaa.model.Feedback;
import com.astrasquad.tharuniyaa.repository.FeedbackRepository;
import com.astrasquad.tharuniyaa.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public FeedbackResponse createFeedback(FeedbackRequest feedbackRequest) {
        Feedback feedback = mapFeedbackRequestToFeedback(feedbackRequest);
        Feedback createdFeedback = feedbackRepository.save(feedback);
        return mapFeedbackToFeedbackResponse(createdFeedback);
    }

    @Override
    public FeedbackResponse getFeedbackById(Long id) {
        Optional<Feedback> feedbackOptional = feedbackRepository.findById(id);
        return feedbackOptional.map(this::mapFeedbackToFeedbackResponse).orElse(null);
    }

    @Override
    public List<FeedbackResponse> getAllFeedbacks() {
        List<Feedback> feedbackList = feedbackRepository.findAll();
        return feedbackList.stream()
                .map(this::mapFeedbackToFeedbackResponse)
                .collect(Collectors.toList());
    }

    @Override
    public FeedbackResponse updateFeedback(Long id, FeedbackRequest feedbackRequest) {
        Optional<Feedback> feedbackOptional = feedbackRepository.findById(id);
        if (feedbackOptional.isPresent()) {
            Feedback feedback = feedbackOptional.get();
            mapUpdatedFeedbackRequestToFeedback(feedback, feedbackRequest);
            Feedback updatedFeedback = feedbackRepository.save(feedback);
            return mapFeedbackToFeedbackResponse(updatedFeedback);
        }
        return null;
    }

    @Override
    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }

    private Feedback mapFeedbackRequestToFeedback(FeedbackRequest feedbackRequest) {
        return Feedback.builder()
                .name(feedbackRequest.getName())
                .rating(feedbackRequest.getRating())
                .message(feedbackRequest.getMessage())
                .build();
    }

    private FeedbackResponse mapFeedbackToFeedbackResponse(Feedback feedback) {
        return FeedbackResponse.builder()
                .fid(feedback.getFid())
                .name(feedback.getName())
                .rating(feedback.getRating())
                .message(feedback.getMessage())
                .build();
    }

    private void mapUpdatedFeedbackRequestToFeedback(Feedback feedback, FeedbackRequest feedbackRequest) {
        feedback.setName(feedbackRequest.getName());
        feedback.setRating(feedbackRequest.getRating());
        feedback.setMessage(feedbackRequest.getMessage());
    }
}
