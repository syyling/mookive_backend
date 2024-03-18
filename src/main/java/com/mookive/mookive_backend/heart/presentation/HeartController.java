package com.mookive.mookive_backend.heart.presentation;

import com.mookive.mookive_backend.heart.application.dto.response.HeartResponse;
import com.mookive.mookive_backend.heart.application.service.HeartCreateService;
import com.mookive.mookive_backend.heart.application.service.HeartGetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HeartController {

    private final HeartCreateService heartCreateService;
    private final HeartGetService heartGetService;

    @PostMapping("/heart")
    public void createHeart(@RequestParam Long userId, @RequestParam Long movieId) {
        heartCreateService.createHeart(userId, movieId);
    }

    @GetMapping("/heart/check")
    public HeartResponse.HeartCheckResponse checkHeart(@RequestParam Long userId, @RequestParam Long movieId) {
        return heartGetService.checkHeart(userId, movieId);
    }
}
