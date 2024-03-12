package com.mookive.mookive_backend.movie.domain.repository;

import com.mookive.mookive_backend.movie.domain.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    Movie findByTitle(String title);

    Movie findByTmdbId(String tmdbId);
}
