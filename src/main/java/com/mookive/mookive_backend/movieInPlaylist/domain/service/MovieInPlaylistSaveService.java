package com.mookive.mookive_backend.movieInPlaylist.domain.service;


import com.mookive.mookive_backend.movieInPlaylist.domain.entity.MovieInPlaylist;
import com.mookive.mookive_backend.movieInPlaylist.domain.respository.MovieInPlaylistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieInPlaylistSaveService {

    private final MovieInPlaylistRepository movieInPlaylistRepository;

    public void save(MovieInPlaylist movieInPlaylist) {
        movieInPlaylistRepository.save(movieInPlaylist);
    }
}
