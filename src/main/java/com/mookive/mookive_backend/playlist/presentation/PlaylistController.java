package com.mookive.mookive_backend.playlist.presentation;

import com.mookive.mookive_backend.playlist.application.dto.request.PlaylistRequest;
import com.mookive.mookive_backend.playlist.application.service.PlaylistCreateService;
import com.mookive.mookive_backend.playlist.application.service.PlaylistDeleteService;
import com.mookive.mookive_backend.playlist.application.service.PlaylistUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PlaylistController {

    private final PlaylistCreateService playlistCreateService;
    private final PlaylistDeleteService playlistDeleteService;
    private final PlaylistUpdateService playlistUpdateService;

    @PostMapping("/playlist")
    public void createPlaylist(@RequestBody PlaylistRequest.PlaylistCreateRequest playlistCreateRequest) {
        playlistCreateService.createPlaylist(playlistCreateRequest);
    }

    @PostMapping("/playlist/delete")
    public void deletePlaylist(@RequestParam Long playlistId) {
        playlistDeleteService.deletePlaylist(playlistId);
    }

    @PostMapping("/playlist/update")
    public void updatePlaylist(@RequestBody PlaylistRequest.PlaylistUpdateRequest playlistUpdateRequest) {
        playlistUpdateService.updatePlaylist(playlistUpdateRequest);
    }

}
