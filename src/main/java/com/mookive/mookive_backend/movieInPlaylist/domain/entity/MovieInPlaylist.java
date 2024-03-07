package com.mookive.mookive_backend.movieInPlaylist.domain.entity;

import com.mookive.mookive_backend.movie.domain.entity.Movie;
import com.mookive.mookive_backend.playlist.domain.entity.Playlist;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MovieInPlaylist {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "playlist_id")
    private Playlist playlist;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @Builder
    public MovieInPlaylist(Playlist playlist, Movie movie) {
        this.playlist = playlist;
        this.movie = movie;
    }
}
