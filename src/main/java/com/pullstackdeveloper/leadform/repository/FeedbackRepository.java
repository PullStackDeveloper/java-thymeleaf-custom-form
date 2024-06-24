package com.pullstackdeveloper.leadform.repository;

import com.pullstackdeveloper.leadform.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}