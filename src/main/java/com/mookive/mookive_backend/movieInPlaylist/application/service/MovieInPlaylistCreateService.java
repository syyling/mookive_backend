package com.mookive.mookive_backend.movieInPlaylist.application.service;

import com.mookive.mookive_backend.movie.domain.entity.Movie;
import com.mookive.mookive_backend.movie.domain.service.MovieQueryService;
import com.mookive.mookive_backend.movieInPlaylist.application.dto.request.MovieInPlaylistRequest;
import com.mookive.mookive_backend.movieInPlaylist.application.mapper.MovieInPlaylistMapper;
import com.mookive.mookive_backend.movieInPlaylist.domain.entity.MovieInPlaylist;
import com.mookive.mookive_backend.movieInPlaylist.domain.service.MovieInPlaylistSaveService;
import com.mookive.mookive_backend.playlist.domain.entity.Playlist;
import com.mookive.mookive_backend.playlist.domain.service.PlaylistQueryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MovieInPlaylistCreateService {

    private final PlaylistQueryService playlistQueryService;
    private final MovieQueryService movieQueryService;
    private final MovieInPlaylistSaveService movieInPlaylistSaveService;

    public void createMovieInPlaylist(MovieInPlaylistRequest.MovieInPlaylistCreateRequest movieInPlaylistCreateRequest) {
        Long playlistId = movieInPlaylistCreateRequest.getPlaylistId();
        Playlist playlist = playlistQueryService.findById(playlistId);
        List<Long> movieIdList = movieInPlaylistCreateRequest.getMovieIdList();

        for(Long movieId : movieIdList) {
            Movie movie = movieQueryService.findById(movieId);
            MovieInPlaylist movieInPlaylist = MovieInPlaylistMapper.mapToMovieInPlaylist(movie, playlist);
            movieInPlaylistSaveService.save(movieInPlaylist);
        }
    }
}
