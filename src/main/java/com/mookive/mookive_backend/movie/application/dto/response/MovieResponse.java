package com.mookive.mookive_backend.movie.application.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MovieResponse {

    @Getter
    @NoArgsConstructor
    public static class MovieDetailResponse {

        private String title;
        private String director;
        private String genre;
        private String year;
        private String plot;
        private String poster;
        private String nation;

        @Builder
        public MovieDetailResponse(String title, String director, String genre, String year, String plot, String poster, String nation) {
            this.title = title;
            this.director = director;
            this.genre = genre;
            this.year = year;
            this.plot = plot;
            this.poster = poster;
            this.nation = nation;
        }
    }
}
