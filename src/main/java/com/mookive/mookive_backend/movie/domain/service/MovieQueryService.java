package com.mookive.mookive_backend.movie.domain.service;

import com.mookive.mookive_backend.movie.domain.entity.Movie;
import com.mookive.mookive_backend.movie.domain.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieQueryService {

    private final MovieRepository movieRepository;

    public Movie findByTitle(String title) {
        return movieRepository.findByTitle(title);
    }
}
