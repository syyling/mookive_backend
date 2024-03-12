package com.mookive.mookive_backend.movie.application.mapper;

import com.mookive.mookive_backend.movie.application.dto.response.MovieResponse;
import com.mookive.mookive_backend.movie.domain.entity.Movie;

public class MovieMapper {

    public static MovieResponse.MovieDetailResponse mapToMovieDetailResponse(Movie movie) {
        return MovieResponse.MovieDetailResponse.builder()
                .title(movie.getTitle())
                .director(movie.getDirector())
                .genre(movie.getGenre())
                .year(movie.getYear())
                .plot(movie.getPlot())
                .nation(movie.getNation())
                .poster(movie.getPoster())
                .build();
    }
}
