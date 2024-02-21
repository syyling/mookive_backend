package com.mookive.mookive_backend.user.presentation;

import com.mookive.mookive_backend.user.application.dto.UserRequest;
import com.mookive.mookive_backend.user.application.service.UserCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserCreateService userCreateService;

    @PostMapping("/user/create")
    void createUser(@RequestBody UserRequest.UserCreateRequest userCreateRequest) {
        userCreateService.createUser(userCreateRequest);
    }
}
