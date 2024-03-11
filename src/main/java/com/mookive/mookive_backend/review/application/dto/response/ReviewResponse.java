package com.mookive.mookive_backend.review.application.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

public class ReviewResponse {

    @Getter
    @NoArgsConstructor
    public static class ReviewDetailResponse {
        private String rating;
        private String text;
        private LocalDate date;
        private List<String> keywords;

        @Builder
        public ReviewDetailResponse(String rating, String text, LocalDate date, List<String> keywords) {
            this.rating = rating;
            this.text = text;
            this.date = date;
            this.keywords = keywords;
        }
    }

}
