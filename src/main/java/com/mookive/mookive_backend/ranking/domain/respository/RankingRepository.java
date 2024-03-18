package com.mookive.mookive_backend.ranking.domain.respository;

import com.mookive.mookive_backend.ranking.domain.entity.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RankingRepository extends JpaRepository<Ranking, Long> {

    List<Ranking> findByUserId(Long userId);
}
