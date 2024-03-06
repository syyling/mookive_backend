package com.mookive.mookive_backend.review.presentation;

import com.mookive.mookive_backend.review.application.dto.request.ReviewRequest;
import com.mookive.mookive_backend.review.application.service.ReviewCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewCreateService reviewCreateService;

    @PostMapping("/review")
    public void createReview(@RequestBody ReviewRequest.ReviewCreateRequest reviewCreateRequest) {
        reviewCreateService.createReview(reviewCreateRequest);
    }
}
