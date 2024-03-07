package com.mookive.mookive_backend.playlist.application.mapper;

import com.mookive.mookive_backend.playlist.application.dto.request.PlaylistRequest;
import com.mookive.mookive_backend.playlist.domain.entity.Playlist;
import com.mookive.mookive_backend.user.domain.entity.User;

public class PlaylistMapper {

    public static Playlist mapToPlaylist(User user, PlaylistRequest.PlaylistCreateRequest playlistCreateRequest) {
        return Playlist.builder()
                .name(playlistCreateRequest.getName())
                .user(user)
                .build();
    }
}
