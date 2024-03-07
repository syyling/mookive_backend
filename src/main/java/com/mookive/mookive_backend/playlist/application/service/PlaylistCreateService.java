package com.mookive.mookive_backend.playlist.application.service;

import com.mookive.mookive_backend.playlist.application.dto.request.PlaylistRequest;
import com.mookive.mookive_backend.playlist.application.mapper.PlaylistMapper;
import com.mookive.mookive_backend.playlist.domain.entity.Playlist;
import com.mookive.mookive_backend.playlist.domain.service.PlaylistSaveService;
import com.mookive.mookive_backend.user.domain.entity.User;
import com.mookive.mookive_backend.user.domain.service.UserQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlaylistCreateService {

    private final UserQueryService userQueryService;
    private final PlaylistSaveService playlistSaveService;

    public void createPlaylist(PlaylistRequest.PlaylistCreateRequest playlistCreateRequest) {
        System.out.println("playlistCreateRequest = " + playlistCreateRequest.getName());
        Long userId = playlistCreateRequest.getUserId();
        System.out.println("userId = " + userId);
        User user = userQueryService.findById(userId);
        Playlist playlist = PlaylistMapper.mapToPlaylist(user, playlistCreateRequest);
        playlistSaveService.savePlaylist(playlist);
    }
}
