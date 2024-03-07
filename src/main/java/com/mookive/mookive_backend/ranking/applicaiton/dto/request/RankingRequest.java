package com.mookive.mookive_backend.ranking.applicaiton.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class RankingRequest {

    @Getter
    @NoArgsConstructor
    public static class RankingCreateRequest {

        private Long userId;
        private Long movieId;
        private int rankingNumber;

        @Builder
        public RankingCreateRequest(Long userId, Long movieId, int rankingNumber) {
            this.userId = userId;
            this.movieId = movieId;
            this.rankingNumber = rankingNumber;
        }
    }
}
