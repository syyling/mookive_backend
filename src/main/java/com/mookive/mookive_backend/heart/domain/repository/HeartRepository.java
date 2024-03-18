package com.mookive.mookive_backend.heart.domain.repository;

import com.mookive.mookive_backend.heart.domain.entity.Heart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeartRepository extends JpaRepository<Heart, Long> {

    void deleteByUserIdAndMovieId(Long userId, Long movieId);

    boolean existsByUserIdAndMovieId(Long userId, Long movieId);
}
