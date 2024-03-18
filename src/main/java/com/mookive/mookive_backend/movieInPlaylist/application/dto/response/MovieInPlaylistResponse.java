package com.mookive.mookive_backend.movieInPlaylist.application.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MovieInPlaylistResponse {

    @Getter
    @NoArgsConstructor
    public static class MovieInPlaylistDefaultResponse {
        private String title;
        private String poster;
        private String rating;

        @Builder
        public MovieInPlaylistDefaultResponse(String title, String poster, String rating) {
            this.title = title;
            this.poster = poster;
            this.rating = rating;
        }
    }
}
