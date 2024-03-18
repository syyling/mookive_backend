package com.mookive.mookive_backend.heart.application.service;

import com.mookive.mookive_backend.heart.domain.entity.Heart;
import com.mookive.mookive_backend.heart.domain.service.HeartDeleteService;
import com.mookive.mookive_backend.heart.domain.service.HeartQueryService;
import com.mookive.mookive_backend.heart.domain.service.HeartSaveService;
import com.mookive.mookive_backend.movie.domain.entity.Movie;
import com.mookive.mookive_backend.movie.domain.service.MovieQueryService;
import com.mookive.mookive_backend.user.domain.entity.User;
import com.mookive.mookive_backend.user.domain.service.UserQueryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class HeartCreateService {

    private final HeartQueryService heartQueryService;
    private final HeartSaveService heartSaveService;
    private final HeartDeleteService heartDeleteService;
    private final UserQueryService userQueryService;
    private final MovieQueryService movieQueryService;

    public void createHeart(Long userId, Long movieId) {
        if (heartQueryService.existsByUserIdAndMovieId(userId, movieId)) {
            heartDeleteService.deleteByUserIdAndMovieId(userId, movieId);
        } else {
            User user = userQueryService.findById(userId);
            Movie movie = movieQueryService.findById(movieId);
            Heart heart = Heart.builder()
                    .user(user)
                    .movie(movie)
                    .build();
            heartSaveService.save(heart);
        }
    }
}
