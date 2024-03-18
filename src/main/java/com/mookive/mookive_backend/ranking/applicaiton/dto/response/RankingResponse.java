package com.mookive.mookive_backend.ranking.applicaiton.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class RankingResponse {

    @Getter
    @NoArgsConstructor
    public static class RankingInfoResponse {

        private int rankingNumber;
        private String poster;
        private String title;

        @Builder
        public RankingInfoResponse(int rankingNumber, String poster, String title) {
            this.rankingNumber = rankingNumber;
            this.poster = poster;
            this.title = title;
        }
    }
}
