package com.mookive.mookive_backend.heart.domain.service;


import com.mookive.mookive_backend.heart.domain.repository.HeartRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class HeartQueryService {

    private final HeartRepository heartRepository;

    public boolean existsByUserIdAndMovieId(Long userId, Long movieId) {
        return heartRepository.existsByUserIdAndMovieId(userId, movieId);
    }
}
