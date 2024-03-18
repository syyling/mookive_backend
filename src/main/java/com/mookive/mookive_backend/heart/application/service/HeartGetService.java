package com.mookive.mookive_backend.heart.application.service;

import com.mookive.mookive_backend.heart.application.dto.response.HeartResponse;
import com.mookive.mookive_backend.heart.application.mapper.HeartMapper;
import com.mookive.mookive_backend.heart.domain.service.HeartQueryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class HeartGetService {

    private final HeartQueryService heartQueryService;

    public HeartResponse.HeartCheckResponse checkHeart(Long userId, Long movieId) {
        boolean isHeart = heartQueryService.existsByUserIdAndMovieId(userId, movieId);
        return HeartMapper.mapToHeartCheckResponse(isHeart);
    }
}
