package com.mookive.mookive_backend.review.domain.service;

import com.mookive.mookive_backend.review.domain.entity.Review;
import com.mookive.mookive_backend.review.domain.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewSaveService {

    private final ReviewRepository reviewRepository;

    public void saveReview(Review review) {
        reviewRepository.save(review);
    }
}
