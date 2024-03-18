package com.mookive.mookive_backend.ranking.applicaiton.service;

import com.mookive.mookive_backend.movie.domain.entity.Movie;
import com.mookive.mookive_backend.movie.domain.service.MovieQueryService;
import com.mookive.mookive_backend.ranking.applicaiton.dto.request.RankingRequest;
import com.mookive.mookive_backend.ranking.applicaiton.mapper.RankingMapper;
import com.mookive.mookive_backend.ranking.domain.entity.Ranking;
import com.mookive.mookive_backend.ranking.domain.service.RankingSaveService;
import com.mookive.mookive_backend.user.domain.entity.User;
import com.mookive.mookive_backend.user.domain.service.UserQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RankingCreateService {

    private final RankingSaveService rankSaveService;
    private final MovieQueryService movieQueryService;
    private final UserQueryService userQueryService;

    public void createRanking(List<RankingRequest.RankingCreateRequest> rankCreateRequestList) {

        for(RankingRequest.RankingCreateRequest rankingCreateRequest : rankCreateRequestList) {
            Long movieId = rankingCreateRequest.getMovieId();
            Movie movie = movieQueryService.findById(movieId);
            Long userId = rankingCreateRequest.getUserId();
            User user = userQueryService.findById(userId);
            int rankingNumber = rankingCreateRequest.getRankingNumber();
            Ranking ranking = RankingMapper.mapToRanking(movie, user, rankingNumber);
            rankSaveService.saveRanking(ranking);
        }
    }
}
