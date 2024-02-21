package com.mookive.mookive_backend.user.application.mapper;

import com.mookive.mookive_backend.user.application.dto.UserRequest;
import com.mookive.mookive_backend.user.domain.entity.User;

public class UserMapper {

    public static User mapToUser(UserRequest.UserCreateRequest request) {
        return User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .profileUrl(request.getProfileUrl())
                .build();
    }
}
