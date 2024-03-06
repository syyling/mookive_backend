package com.mookive.mookive_backend.review.application.service;


import com.mookive.mookive_backend.keyword.application.mapper.KeywordMapper;
import com.mookive.mookive_backend.keyword.domain.entity.Keyword;
import com.mookive.mookive_backend.keyword.domain.service.KeywordSaveService;
import com.mookive.mookive_backend.movie.domain.entity.Movie;
import com.mookive.mookive_backend.movie.domain.service.MovieQueryService;
import com.mookive.mookive_backend.review.application.dto.request.ReviewRequest;
import com.mookive.mookive_backend.review.application.mapper.ReviewMapper;
import com.mookive.mookive_backend.review.domain.entity.Review;
import com.mookive.mookive_backend.review.domain.service.ReviewSaveService;
import com.mookive.mookive_backend.user.domain.entity.User;
import com.mookive.mookive_backend.user.domain.service.UserQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class ReviewCreateService {

    private final MovieQueryService movieQueryService;
    private final UserQueryService userQueryService;
    private final ReviewSaveService reviewSaveService;
    private final KeywordSaveService keywordSaveService;

    public void createReview(ReviewRequest.ReviewCreateRequest reviewCreateRequest) {
        Long movieId = reviewCreateRequest.getMovieId();
        Movie movie = movieQueryService.findById(movieId);
        Long userId = reviewCreateRequest.getUserId();
        User user = userQueryService.findById(userId);
        Review review = ReviewMapper.mapToReview(reviewCreateRequest, movie, user);
        reviewSaveService.saveReview(review);

        ArrayList<String> keywords = reviewCreateRequest.getKeywords();
        for(String word : keywords){
            Keyword keyword = KeywordMapper.mapToKeyword(review, word);
            keywordSaveService.saveKeyword(keyword);
        }
    }
}
