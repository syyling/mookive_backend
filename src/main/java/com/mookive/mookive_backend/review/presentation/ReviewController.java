package com.mookive.mookive_backend.review.presentation;

import com.mookive.mookive_backend.review.application.dto.request.ReviewRequest;
import com.mookive.mookive_backend.review.application.dto.response.ReviewResponse;
import com.mookive.mookive_backend.review.application.service.ReviewCreateService;
import com.mookive.mookive_backend.review.application.service.ReviewGetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewCreateService reviewCreateService;
    private final ReviewGetService reviewGetService;

    @PostMapping("/review")
    public void createReview(@RequestBody ReviewRequest.ReviewCreateRequest reviewCreateRequest) {
        reviewCreateService.createReview(reviewCreateRequest);
    }

    @GetMapping("/review/{reviewId}")
    public ReviewResponse.ReviewDetailResponse getReview(@PathVariable Long reviewId) {
        return reviewGetService.getReview(reviewId);
    }

}
