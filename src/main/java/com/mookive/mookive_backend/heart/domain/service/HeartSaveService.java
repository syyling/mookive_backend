package com.mookive.mookive_backend.heart.domain.service;

import com.mookive.mookive_backend.heart.domain.entity.Heart;
import com.mookive.mookive_backend.heart.domain.repository.HeartRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class HeartSaveService {

    private final HeartRepository heartRepository;

    public void save(Heart heart) {
        heartRepository.save(heart);
    }

}
