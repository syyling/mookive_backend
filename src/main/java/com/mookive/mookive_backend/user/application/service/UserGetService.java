package com.mookive.mookive_backend.user.application.service;

import com.mookive.mookive_backend.user.application.dto.response.UserResponse;
import com.mookive.mookive_backend.user.application.mapper.UserMapper;
import com.mookive.mookive_backend.user.domain.entity.User;
import com.mookive.mookive_backend.user.domain.service.UserQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserGetService {

    private final UserQueryService userQueryService;

    public UserResponse.UserInfoResponse getUser(Long userId) {
        User user = userQueryService.findById(userId);
        return UserMapper.mapToUserInfoResponse(user);
    }
}
