package com.mookive.mookive_backend.movie.presentation;


import com.mookive.mookive_backend.movie.application.dto.response.MovieResponse;
import com.mookive.mookive_backend.movie.application.service.MovieGetService;
import lombok.RequiredArgsConstructor;
import org.json.JSONException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieGetService movieGetService;

    @GetMapping("/movie/detail")
    public MovieResponse.MovieDetailResponse getMovieDetail(@RequestParam String tmdbId) throws JSONException {
        return movieGetService.getMovieDetail(tmdbId);
    }
}
