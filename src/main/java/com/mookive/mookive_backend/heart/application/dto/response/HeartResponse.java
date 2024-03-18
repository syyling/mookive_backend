package com.mookive.mookive_backend.heart.application.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class HeartResponse {

    @Getter
    @NoArgsConstructor
    public static class HeartCheckResponse {

        private boolean isHeart;

        @Builder
        public HeartCheckResponse(boolean isHeart) {
            this.isHeart = isHeart;
        }
    }
}
