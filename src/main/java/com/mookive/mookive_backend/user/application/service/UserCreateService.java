package com.mookive.mookive_backend.user.application.service;

import com.mookive.mookive_backend.heartPlaylist.domain.HeartPlaylist;
import com.mookive.mookive_backend.heartPlaylist.service.HeartPlaylistSaveService;
import com.mookive.mookive_backend.playlist.domain.entity.Playlist;
import com.mookive.mookive_backend.playlist.domain.service.PlaylistSaveService;
import com.mookive.mookive_backend.user.application.dto.request.UserRequest;
import com.mookive.mookive_backend.user.application.mapper.UserMapper;
import com.mookive.mookive_backend.user.domain.entity.User;
import com.mookive.mookive_backend.user.domain.service.UserSaveService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserCreateService {

    private final UserSaveService userSaveService;
    private final PlaylistSaveService playlistSaveService;
    private final HeartPlaylistSaveService heartPlaylistSaveService;


    public void createUser(UserRequest.UserCreateRequest userCreateRequest) {
        User user = UserMapper.mapToUser(userCreateRequest);
        userSaveService.saveUser(user);
        Playlist playlist = Playlist.builder()
                .user(user)
                .name("나중에 볼 영화")
                .build();
        playlistSaveService.savePlaylist(playlist);
        heartPlaylistSaveService.save(HeartPlaylist.builder()
                .user(user)
                .playlist(playlist)
                .build());

    }
}
