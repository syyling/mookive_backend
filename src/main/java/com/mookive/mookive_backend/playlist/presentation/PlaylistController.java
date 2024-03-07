package com.mookive.mookive_backend.playlist.presentation;

import com.mookive.mookive_backend.playlist.application.dto.request.PlaylistRequest;
import com.mookive.mookive_backend.playlist.application.service.PlaylistCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PlaylistController {

    private final PlaylistCreateService playlistCreateService;

    @PostMapping("/playlist")
    public void createPlaylist(@RequestBody PlaylistRequest.PlaylistCreateRequest playlistCreateRequest) {
        playlistCreateService.createPlaylist(playlistCreateRequest);
    }
}
