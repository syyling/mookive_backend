package com.mookive.mookive_backend.heart.application.mapper;

import com.mookive.mookive_backend.heart.application.dto.response.HeartResponse;

public class HeartMapper {

    public static HeartResponse.HeartCheckResponse mapToHeartCheckResponse(boolean isHeart) {
        return HeartResponse.HeartCheckResponse.builder()
                .isHeart(isHeart)
                .build();
    }
}
