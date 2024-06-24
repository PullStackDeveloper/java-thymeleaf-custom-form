package com.pullstackdeveloper.leadform.service;

import com.pullstackdeveloper.leadform.dto.FeedbackDTO;
import com.pullstackdeveloper.leadform.model.Feedback;
import com.pullstackdeveloper.leadform.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;

    public void saveFeedback(FeedbackDTO feedbackDTO) {
        Feedback feedback = new Feedback();
        feedback.setName(feedbackDTO.getName());
        feedback.setEmail(feedbackDTO.getEmail());
        feedback.setComments(feedbackDTO.getComments());
        feedbackRepository.save(feedback);
    }
}
