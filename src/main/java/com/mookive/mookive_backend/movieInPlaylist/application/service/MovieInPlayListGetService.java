package com.mookive.mookive_backend.movieInPlaylist.application.service;

import com.mookive.mookive_backend.movieInPlaylist.application.dto.response.MovieInPlaylistResponse;
import com.mookive.mookive_backend.movieInPlaylist.application.mapper.MovieInPlaylistMapper;
import com.mookive.mookive_backend.movieInPlaylist.domain.entity.MovieInPlaylist;
import com.mookive.mookive_backend.movieInPlaylist.domain.service.MovieInPlaylistQueryService;
import com.mookive.mookive_backend.playlist.domain.entity.Playlist;
import com.mookive.mookive_backend.playlist.domain.service.PlaylistQueryService;
import com.mookive.mookive_backend.review.domain.entity.Review;
import com.mookive.mookive_backend.review.domain.service.ReviewQueryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class MovieInPlayListGetService {

    private final MovieInPlaylistQueryService movieInPlaylistQueryService;
    private final PlaylistQueryService playlistQueryService;
    private final ReviewQueryService reviewQueryService;

    public List<MovieInPlaylistResponse.MovieInPlaylistDefaultResponse> getMovieInPlayList(Long playlistId) {
        Playlist playlist = playlistQueryService.findById(playlistId);
        Long userId = playlist.getUser().getId();

        List<MovieInPlaylist> movieInPlaylistList = movieInPlaylistQueryService.findByPlaylistId(playlistId);
        List<MovieInPlaylistResponse.MovieInPlaylistDefaultResponse> movieInPlaylistDefaultResponseList = movieInPlaylistList.stream().map(movieInPlaylist ->
        {
            Long movieId = movieInPlaylist.getMovie().getId();
            Review review = reviewQueryService.findByUserIdAndMovieId(userId, movieId);
            String rating = review != null ? review.getRating() : null;
            return MovieInPlaylistMapper.mapToMovieInPlaylistDefaultResponse(movieInPlaylist, rating);
        }).collect(Collectors.toList());

        return movieInPlaylistDefaultResponseList;

    }
}
