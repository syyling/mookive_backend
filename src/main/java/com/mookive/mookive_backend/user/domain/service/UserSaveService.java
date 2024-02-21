package com.mookive.mookive_backend.user.domain.service;

import com.mookive.mookive_backend.user.domain.entity.User;
import com.mookive.mookive_backend.user.domain.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class UserSaveService {

    private final UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }
}
