package com.mookive.mookive_backend.movieInPlaylist.presentation;


import com.mookive.mookive_backend.movieInPlaylist.application.dto.request.MovieInPlaylistRequest;
import com.mookive.mookive_backend.movieInPlaylist.application.dto.response.MovieInPlaylistResponse;
import com.mookive.mookive_backend.movieInPlaylist.application.service.MovieInPlayListGetService;
import com.mookive.mookive_backend.movieInPlaylist.application.service.MovieInPlaylistCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MovieInPlayListController {

    private final MovieInPlaylistCreateService movieInPlaylistCreateService;
    private final MovieInPlayListGetService movieInPlayListGetService;

    @PostMapping("/movieInPlaylist")
    public void createMovieInPlaylist(@RequestBody MovieInPlaylistRequest.MovieInPlaylistCreateRequest movieInPlaylistCreateRequest) {
        movieInPlaylistCreateService.createMovieInPlaylist(movieInPlaylistCreateRequest);
    }

    @GetMapping("/movieInPlaylist/{playlistId}")
    public List<MovieInPlaylistResponse.MovieInPlaylistDefaultResponse> getMovieInPlaylist(@PathVariable Long playlistId) {
        return movieInPlayListGetService.getMovieInPlayList(playlistId);
    }
}
