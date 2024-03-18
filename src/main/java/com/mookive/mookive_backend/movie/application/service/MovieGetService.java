package com.mookive.mookive_backend.movie.application.service;

import com.mookive.mookive_backend.movie.application.dto.response.MovieResponse;
import com.mookive.mookive_backend.movie.application.mapper.MovieMapper;
import com.mookive.mookive_backend.movie.domain.entity.Movie;
import com.mookive.mookive_backend.movie.domain.service.MovieQueryService;
import com.mookive.mookive_backend.movie.domain.service.MovieSaveService;
import com.mookive.mookive_backend.movie.infra.MovieSearchService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.json.JSONException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class MovieGetService {

    private final MovieQueryService movieQueryService;
    private final MovieSearchService movieSearchService;
    private final MovieSaveService movieSaveService;

    public MovieResponse.MovieDetailResponse getMovieDetail(String tmdbId) throws JSONException {
        Movie movie = movieQueryService.findByTmdbId(tmdbId);
        if(movie == null) {
            movie = movieSearchService.searchMovie(tmdbId);
            movieSaveService.save(movie);
        }
        return MovieMapper.mapToMovieDetailResponse(movie);
    }
}
