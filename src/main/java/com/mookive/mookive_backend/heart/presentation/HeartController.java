package com.mookive.mookive_backend.heart.presentation;

import com.mookive.mookive_backend.heart.application.service.HeartCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HeartController {

    private final HeartCreateService heartCreateService;

    @PostMapping("/heart")
    public void createHeart(@RequestParam Long userId, @RequestParam Long movieId) {
        heartCreateService.createHeart(userId, movieId);
    }
}
