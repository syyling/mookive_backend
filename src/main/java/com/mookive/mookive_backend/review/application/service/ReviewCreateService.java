package com.mookive.mookive_backend.review.application.service;


import com.mookive.mookive_backend.keyword.application.mapper.KeywordMapper;
import com.mookive.mookive_backend.keyword.domain.entity.Keyword;
import com.mookive.mookive_backend.keyword.domain.repository.KeywordRepository;
import com.mookive.mookive_backend.keyword.domain.service.KeywordDeleteService;
import com.mookive.mookive_backend.keyword.domain.service.KeywordSaveService;
import com.mookive.mookive_backend.movie.domain.entity.Movie;
import com.mookive.mookive_backend.movie.domain.service.MovieQueryService;
import com.mookive.mookive_backend.review.application.dto.request.ReviewRequest;
import com.mookive.mookive_backend.review.application.mapper.ReviewMapper;
import com.mookive.mookive_backend.review.domain.entity.Review;
import com.mookive.mookive_backend.review.domain.service.ReviewQueryService;
import com.mookive.mookive_backend.review.domain.service.ReviewSaveService;
import com.mookive.mookive_backend.user.domain.entity.User;
import com.mookive.mookive_backend.user.domain.service.UserQueryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewCreateService {

    private final MovieQueryService movieQueryService;
    private final UserQueryService userQueryService;
    private final ReviewSaveService reviewSaveService;
    private final KeywordSaveService keywordSaveService;
    private final KeywordDeleteService keywordDeleteService;
    private final ReviewQueryService reviewQueryService;

    public void createReview(ReviewRequest.ReviewCreateRequest reviewCreateRequest) {
        Long movieId = reviewCreateRequest.getMovieId();
        Long userId = reviewCreateRequest.getUserId();
        Optional<Review> optionalReview = reviewQueryService.findByUserIdAndMovieId(userId, movieId);
        if(optionalReview.isPresent()){
            Review review = optionalReview.get();
            LocalDate date = reviewCreateRequest.getDate();
            String rating = reviewCreateRequest.getRating();
            String text = reviewCreateRequest.getText();
            ArrayList<String> keywords = reviewCreateRequest.getKeywords();
            review.updateReview(rating, text, date);
            keywordDeleteService.deleteAllByReviewId(review.getId());
            saveKeywords(keywords, review, movieId);
        }
        else {
            Movie movie = movieQueryService.findById(movieId);
            User user = userQueryService.findById(userId);
            Review review = ReviewMapper.mapToReview(reviewCreateRequest, movie, user);
            reviewSaveService.saveReview(review);
            ArrayList<String> keywords = reviewCreateRequest.getKeywords();
            saveKeywords(keywords, review, movieId);
        }
    }

    private void saveKeywords(ArrayList<String> keywords, Review review, Long movieId) {
        for(String word : keywords){
            Keyword keyword = KeywordMapper.mapToKeyword(review, word, movieId);
            keywordSaveService.saveKeyword(keyword);
        }
    }
}
