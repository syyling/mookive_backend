package com.mookive.mookive_backend.user.application.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserResponse {

    @Getter
    @NoArgsConstructor
    public static class UserInfoResponse {

        private String name;
        private String profileUrl;

        @Builder
        public UserInfoResponse(String name, String profileUrl) {
            this.name = name;
            this.profileUrl = profileUrl;
        }
    }
}
