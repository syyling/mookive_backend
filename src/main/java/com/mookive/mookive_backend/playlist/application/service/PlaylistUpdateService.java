package com.mookive.mookive_backend.playlist.application.service;

import com.mookive.mookive_backend.playlist.application.dto.request.PlaylistRequest;
import com.mookive.mookive_backend.playlist.domain.entity.Playlist;
import com.mookive.mookive_backend.playlist.domain.service.PlaylistQueryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class PlaylistUpdateService {

    private final PlaylistQueryService playlistQueryService;

    public void updatePlaylist(PlaylistRequest.PlaylistUpdateRequest playlistUpdateRequest) {
        Long playlistId = playlistUpdateRequest.getPlaylistId();
        String name = playlistUpdateRequest.getName();

        Playlist playlist = playlistQueryService.findById(playlistId);
        playlist.updateName(name);

    }
}
