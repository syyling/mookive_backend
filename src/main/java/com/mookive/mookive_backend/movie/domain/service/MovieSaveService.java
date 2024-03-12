package com.mookive.mookive_backend.movie.domain.service;

import com.mookive.mookive_backend.movie.domain.entity.Movie;
import com.mookive.mookive_backend.movie.domain.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieSaveService {

    private final MovieRepository movieRepository;

    public void save(Movie movie) {
        movieRepository.save(movie);
    }

}
