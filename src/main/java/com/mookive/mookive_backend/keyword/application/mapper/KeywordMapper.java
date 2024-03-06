package com.mookive.mookive_backend.keyword.application.mapper;

import com.mookive.mookive_backend.keyword.domain.entity.Keyword;
import com.mookive.mookive_backend.review.domain.entity.Review;

public class KeywordMapper {

    public static Keyword mapToKeyword(Review review, String word) {
        return Keyword.builder()
                .review(review)
                .word(word)
                .build();
    }
}
