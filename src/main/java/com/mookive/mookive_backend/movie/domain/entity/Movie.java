package com.mookive.mookive_backend.movie.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Movie {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String year;
    private String director;
    private String genre;
    private String plot;
    private String poster;
    private String nation;
    private String tmdbId;


    @Builder
    public Movie(String title, String year, String director, String genre,
                 String plot, String poster, String nation, String tmdbId) {
        this.title = title;
        this.year = year;
        this.director = director;
        this.genre = genre;
        this.plot = plot;
        this.poster = poster;
        this.nation = nation;
        this.tmdbId = tmdbId;
    }
}
