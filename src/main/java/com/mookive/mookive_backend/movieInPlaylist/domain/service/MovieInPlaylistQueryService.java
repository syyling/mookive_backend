package com.mookive.mookive_backend.movieInPlaylist.domain.service;

import com.mookive.mookive_backend.movieInPlaylist.domain.entity.MovieInPlaylist;
import com.mookive.mookive_backend.movieInPlaylist.domain.respository.MovieInPlaylistRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MovieInPlaylistQueryService {

    private final MovieInPlaylistRepository movieInPlaylistRepository;

    public List<MovieInPlaylist> findByPlaylistId(Long playlistId) {
        return movieInPlaylistRepository.findByPlaylistId(playlistId);
    }
}
