package com.mookive.mookive_backend.review.application.service;

import com.mookive.mookive_backend.keyword.domain.entity.Keyword;
import com.mookive.mookive_backend.keyword.domain.service.KeywordQueryService;
import com.mookive.mookive_backend.review.application.dto.response.ReviewResponse;
import com.mookive.mookive_backend.review.application.mapper.ReviewMapper;
import com.mookive.mookive_backend.review.domain.entity.Review;
import com.mookive.mookive_backend.review.domain.service.ReviewQueryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewGetService {

    private final ReviewQueryService reviewQueryService;
    private final KeywordQueryService keywordQueryService;

    public ReviewResponse.ReviewDetailResponse getReview(Long reviewId) {
        Review review = reviewQueryService.findById(reviewId);
        List<Keyword> keywordList = keywordQueryService.findByReviewId(reviewId);
        List<String> keywords= new ArrayList<>();
        for(Keyword keyword : keywordList){
            keywords.add(keyword.getWord());
        }
        return ReviewMapper.mapToReviewDetailResponse(review, keywords);
    }
}
