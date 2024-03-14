package com.mookive.mookive_backend.movieInPlaylist.application.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class MovieInPlaylistRequest {

    @Getter
    @NoArgsConstructor
    public static class MovieInPlaylistCreateRequest {

        private List<Long> movieIdList;
        private Long playlistId;

        public MovieInPlaylistCreateRequest(List<Long> movieIdList, Long playlistId) {
            this.movieIdList = movieIdList;
            this.playlistId = playlistId;
        }
    }
}
