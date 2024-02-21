package com.mookive.mookive_backend.user.application.service;

import com.mookive.mookive_backend.user.application.dto.UserRequest;
import com.mookive.mookive_backend.user.application.mapper.UserMapper;
import com.mookive.mookive_backend.user.domain.entity.User;
import com.mookive.mookive_backend.user.domain.service.UserSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCreateService {

    private final UserSaveService userSaveService;

    public void createUser(UserRequest.UserCreateRequest userCreateRequest) {
        User user = UserMapper.mapToUser(userCreateRequest);
        userSaveService.saveUser(user);
    }
}
