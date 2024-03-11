package com.mookive.mookive_backend.review.application.mapper;

import com.mookive.mookive_backend.movie.domain.entity.Movie;
import com.mookive.mookive_backend.review.application.dto.request.ReviewRequest;
import com.mookive.mookive_backend.review.application.dto.response.ReviewResponse;
import com.mookive.mookive_backend.review.domain.entity.Review;
import com.mookive.mookive_backend.user.domain.entity.User;

import java.util.List;

public class ReviewMapper {

    public static Review mapToReview(ReviewRequest.ReviewCreateRequest reviewCreateRequest, Movie movie, User user) {
        return Review.builder()
            .movie(movie)
            .user(user)
            .rating(reviewCreateRequest.getRating())
            .text(reviewCreateRequest.getText())
            .date(reviewCreateRequest.getDate())
            .build();
    }

    public static ReviewResponse.ReviewDetailResponse mapToReviewDetailResponse(Review review, List<String> keywords) {
        return ReviewResponse.ReviewDetailResponse.builder()
            .rating(review.getRating())
            .text(review.getText())
            .date(review.getDate())
            .keywords(keywords)
            .build();
    }
}
