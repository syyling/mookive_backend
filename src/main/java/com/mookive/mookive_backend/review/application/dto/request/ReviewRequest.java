package com.mookive.mookive_backend.review.application.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;

public class ReviewRequest {

    @Getter
    @NoArgsConstructor
    public static class ReviewCreateRequest {
        private Long movieId;
        private Long userId;
        private String rating;
        private String text;
        private LocalDate date;
        private ArrayList<String> keywords;


        @Builder
        public ReviewCreateRequest(Long movieId, Long userId, String rating,
                                   String text, LocalDate date, ArrayList<String> keywords) {
            this.movieId = movieId;
            this.userId = userId;
            this.rating = rating;
            this.text = text;
            this.date = date;
            this.keywords = keywords;
        }
    }
}
