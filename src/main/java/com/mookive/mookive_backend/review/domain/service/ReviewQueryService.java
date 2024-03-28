package com.mookive.mookive_backend.review.domain.service;

import com.mookive.mookive_backend.review.domain.entity.Review;
import com.mookive.mookive_backend.review.domain.repository.ReviewRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewQueryService {

    private final ReviewRepository reviewRepository;

    public Review findById(Long reviewId) {
        return reviewRepository.findById(reviewId)
                .orElseThrow(() ->  new IllegalArgumentException("Review not found"));
    }

    public Optional<Review> findByUserIdAndMovieId(Long userId, Long movieId) {
        return reviewRepository.findByUserIdAndMovieId(userId, movieId);
    }

}
