package com.mookive.mookive_backend.heart.domain.service;


import com.mookive.mookive_backend.heart.domain.repository.HeartRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class HeartDeleteService {

    private final HeartRepository heartRepository;

    public void deleteByUserIdAndMovieId(Long userId, Long movieId) {
        heartRepository.deleteByUserIdAndMovieId(userId, movieId);
    }
}
