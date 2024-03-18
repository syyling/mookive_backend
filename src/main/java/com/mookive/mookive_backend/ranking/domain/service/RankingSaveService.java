package com.mookive.mookive_backend.ranking.domain.service;

import com.mookive.mookive_backend.ranking.domain.entity.Ranking;
import com.mookive.mookive_backend.ranking.domain.respository.RankingRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class RankingSaveService {

    private final RankingRepository rankingRepository;

    public void saveRanking(Ranking ranking) {
        rankingRepository.save(ranking);
    }
}
