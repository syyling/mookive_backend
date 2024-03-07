package com.mookive.mookive_backend.playlist.application.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class PlaylistRequest {

    @Getter
    @NoArgsConstructor
    public static class PlaylistCreateRequest {
        private Long userId;
        private String name;

        @Builder
        public PlaylistCreateRequest(Long userId, String name) {
            this.userId = userId;
            this.name = name;
        }
    }
}
