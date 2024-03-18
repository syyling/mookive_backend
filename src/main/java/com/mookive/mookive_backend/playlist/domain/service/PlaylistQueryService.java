package com.mookive.mookive_backend.playlist.domain.service;

import com.mookive.mookive_backend.playlist.domain.entity.Playlist;
import com.mookive.mookive_backend.playlist.domain.repository.PlaylistRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class PlaylistQueryService {

    private final PlaylistRepository playlistRepository;

    public Playlist findById(Long id) {
        return playlistRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Playlist not found"));
    }
}
