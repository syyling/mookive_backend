package com.mookive.mookive_backend.ranking.domain.service;

import com.mookive.mookive_backend.ranking.domain.entity.Ranking;
import com.mookive.mookive_backend.ranking.domain.respository.RankingRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RankingQueryService {

    private final RankingRepository rankingRepository;

    public List<Ranking> findByUserId(Long userId) {
        return rankingRepository.findByUserId(userId);
    }
}
