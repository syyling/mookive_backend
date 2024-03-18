package com.mookive.mookive_backend.ranking.applicaiton.mapper;

import com.mookive.mookive_backend.movie.domain.entity.Movie;
import com.mookive.mookive_backend.ranking.applicaiton.dto.response.RankingResponse;
import com.mookive.mookive_backend.ranking.domain.entity.Ranking;
import com.mookive.mookive_backend.user.domain.entity.User;

public class RankingMapper {

    public static Ranking mapToRanking(Movie movie, User user, int rankingNumber) {
        return Ranking.builder()
                .movie(movie)
                .user(user)
                .rankingNumber(rankingNumber)
                .build();
    }

    public static RankingResponse.RankingInfoResponse mapToRankingInfoResponse(Ranking ranking) {
        return RankingResponse.RankingInfoResponse.builder()
                .rankingNumber(ranking.getRankingNumber())
                .poster(ranking.getMovie().getPoster())
                .title(ranking.getMovie().getTitle())
                .build();
    }
}
