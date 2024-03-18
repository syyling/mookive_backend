package com.mookive.mookive_backend.movie.domain.service;

import com.mookive.mookive_backend.movie.domain.entity.Movie;
import com.mookive.mookive_backend.movie.domain.repository.MovieRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class MovieSaveService {

    private final MovieRepository movieRepository;

    public void save(Movie movie) {
        movieRepository.save(movie);
    }

}
