package com.mookive.mookive_backend.movieInPlaylist.domain.service;

import com.mookive.mookive_backend.movieInPlaylist.domain.respository.MovieInPlaylistRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class MovieInPlaylistDeleteService {

    private final MovieInPlaylistRepository movieInPlaylistRepository;

    public void deleteByPlaylistIdAndMovieId(Long playlistId, Long movieId) {
        movieInPlaylistRepository.deleteByPlaylistIdAndMovieId(playlistId, movieId);
    }
}
