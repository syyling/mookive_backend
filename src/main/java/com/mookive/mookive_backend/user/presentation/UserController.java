package com.mookive.mookive_backend.user.presentation;

import com.mookive.mookive_backend.user.application.dto.request.UserRequest;
import com.mookive.mookive_backend.user.application.dto.response.UserResponse;
import com.mookive.mookive_backend.user.application.service.UserCreateService;
import com.mookive.mookive_backend.user.application.service.UserGetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserCreateService userCreateService;
    private final UserGetService userGetService;

    @PostMapping("/user/create")
    public void createUser(@RequestBody UserRequest.UserCreateRequest userCreateRequest) {
        userCreateService.createUser(userCreateRequest);
    }

    @GetMapping("/user")
    public UserResponse.UserInfoResponse getUser(@RequestParam Long userId) {
        return userGetService.getUser(userId);
    }
}
