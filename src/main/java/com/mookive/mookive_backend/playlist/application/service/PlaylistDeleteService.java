package com.mookive.mookive_backend.playlist.application.service;

import com.mookive.mookive_backend.playlist.domain.service.PlaylistDeleteDomainService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class PlaylistDeleteService {

    private final PlaylistDeleteDomainService playlistDeleteDomainService;

    public void deletePlaylist(Long playlistId) {
        playlistDeleteDomainService.deleteById(playlistId);
    }
}
