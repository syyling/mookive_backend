package com.mookive.mookive_backend.ranking.applicaiton.service;

import com.mookive.mookive_backend.ranking.applicaiton.dto.response.RankingResponse;
import com.mookive.mookive_backend.ranking.applicaiton.mapper.RankingMapper;
import com.mookive.mookive_backend.ranking.domain.entity.Ranking;
import com.mookive.mookive_backend.ranking.domain.service.RankingQueryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class RankingGetService {

    private final RankingQueryService rankingQueryService;

    public List<RankingResponse.RankingInfoResponse> getRanking(Long userId) {
        List<Ranking> rankingList = rankingQueryService.findByUserId(userId);
        Collections.sort(rankingList, new Comparator<Ranking>() {
            @Override
            public int compare(Ranking o1, Ranking o2) {
                return o1.getRankingNumber()-o2.getRankingNumber();
            }
        });

        List<RankingResponse.RankingInfoResponse> rankingInfoResponseList = rankingList.stream().map(ranking -> {
            RankingResponse.RankingInfoResponse rankingInfoResponse = RankingMapper.mapToRankingInfoResponse(ranking);
            return rankingInfoResponse;
        }).collect(Collectors.toList());

        return rankingInfoResponseList;
    }



}
