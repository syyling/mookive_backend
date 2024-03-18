package com.mookive.mookive_backend.movieInPlaylist.application.mapper;

import com.mookive.mookive_backend.movie.domain.entity.Movie;
import com.mookive.mookive_backend.movieInPlaylist.application.dto.response.MovieInPlaylistResponse;
import com.mookive.mookive_backend.movieInPlaylist.domain.entity.MovieInPlaylist;
import com.mookive.mookive_backend.playlist.domain.entity.Playlist;

public class MovieInPlaylistMapper {

    public static MovieInPlaylist mapToMovieInPlaylist(Movie movie, Playlist playlist) {
        return MovieInPlaylist.builder()
                .movie(movie)
                .playlist(playlist)
                .build();
    }

    public static MovieInPlaylistResponse.MovieInPlaylistDefaultResponse mapToMovieInPlaylistDefaultResponse
            (MovieInPlaylist movieInPlaylist, String rating) {
        return MovieInPlaylistResponse.MovieInPlaylistDefaultResponse.builder()
                .title(movieInPlaylist.getMovie().getTitle())
                .poster(movieInPlaylist.getMovie().getPoster())
                .rating(rating)
                .build();
    }
}
