package com.mookive.mookive_backend.heart.application.service;

import com.mookive.mookive_backend.heart.domain.entity.Heart;
import com.mookive.mookive_backend.heart.domain.service.HeartDeleteService;
import com.mookive.mookive_backend.heart.domain.service.HeartQueryService;
import com.mookive.mookive_backend.heart.domain.service.HeartSaveService;
import com.mookive.mookive_backend.heartPlaylist.service.HeartPlaylistQueryService;
import com.mookive.mookive_backend.movie.domain.entity.Movie;
import com.mookive.mookive_backend.movie.domain.service.MovieQueryService;
import com.mookive.mookive_backend.movieInPlaylist.domain.entity.MovieInPlaylist;
import com.mookive.mookive_backend.movieInPlaylist.domain.service.MovieInPlaylistDeleteService;
import com.mookive.mookive_backend.movieInPlaylist.domain.service.MovieInPlaylistSaveService;
import com.mookive.mookive_backend.playlist.domain.entity.Playlist;
import com.mookive.mookive_backend.user.domain.entity.User;
import com.mookive.mookive_backend.user.domain.service.UserQueryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class HeartCreateService {

    private final HeartQueryService heartQueryService;
    private final HeartSaveService heartSaveService;
    private final HeartDeleteService heartDeleteService;
    private final UserQueryService userQueryService;
    private final MovieQueryService movieQueryService;
    private final HeartPlaylistQueryService heartPlaylistQueryService;
    private final MovieInPlaylistSaveService movieInPlaylistSaveService;
    private final MovieInPlaylistDeleteService movieInPlaylistDeleteService;

    public void createHeart(Long userId, Long movieId) {
        User user = userQueryService.findById(userId);
        Movie movie = movieQueryService.findById(movieId);
        Playlist playlist = heartPlaylistQueryService.findByUserId(userId).getPlaylist();

        if (heartQueryService.existsByUserIdAndMovieId(userId, movieId)) {
            heartDeleteService.deleteByUserIdAndMovieId(userId, movieId);
            movieInPlaylistDeleteService.deleteByPlaylistIdAndMovieId(playlist.getId(), movieId);
        } else {
            Heart heart = Heart.builder()
                    .user(user)
                    .movie(movie)
                    .build();
            heartSaveService.save(heart);

            MovieInPlaylist movieInPlaylist = MovieInPlaylist.builder()
                    .movie(movie)
                    .playlist(playlist)
                    .build();
            movieInPlaylistSaveService.save(movieInPlaylist);
        }
    }
}
