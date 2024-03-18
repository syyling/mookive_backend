package com.mookive.mookive_backend.playlist.domain.service;

import com.mookive.mookive_backend.playlist.domain.entity.Playlist;
import com.mookive.mookive_backend.playlist.domain.repository.PlaylistRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class PlaylistSaveService {

    private final PlaylistRepository playlistRepository;

    public void savePlaylist(Playlist playlist) {
        playlistRepository.save(playlist);
    }
}
