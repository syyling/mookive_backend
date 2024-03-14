package com.mookive.mookive_backend.movieInPlaylist.presentation;


import com.mookive.mookive_backend.movieInPlaylist.application.dto.request.MovieInPlaylistRequest;
import com.mookive.mookive_backend.movieInPlaylist.application.service.MovieInPlaylistCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MovieInPlayListController {

    private final MovieInPlaylistCreateService movieInPlaylistCreateService;

    @PostMapping("/movieInPlaylist")
    public void createMovieInPlaylist(@RequestBody MovieInPlaylistRequest.MovieInPlaylistCreateRequest movieInPlaylistCreateRequest) {
        movieInPlaylistCreateService.createMovieInPlaylist(movieInPlaylistCreateRequest);
    }
}
