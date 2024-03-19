package com.mookive.mookive_backend.heartPlaylist.service;

import com.mookive.mookive_backend.heartPlaylist.domain.HeartPlaylist;
import com.mookive.mookive_backend.heartPlaylist.repository.HeartPlaylistRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class HeartPlaylistQueryService {

    private final HeartPlaylistRepository heartPlaylistRepository;

    public HeartPlaylist findByUserId(Long userId) {
        return heartPlaylistRepository.findByUserId(userId);
    }
}
