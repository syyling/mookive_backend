package com.mookive.mookive_backend.heartPlaylist.service;

import com.mookive.mookive_backend.heartPlaylist.domain.HeartPlaylist;
import com.mookive.mookive_backend.heartPlaylist.repository.HeartPlaylistRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class HeartPlaylistSaveService {

    private final HeartPlaylistRepository heartPlaylistRepository;

    public void save(HeartPlaylist heartPlaylist) {
        heartPlaylistRepository.save(heartPlaylist);
    }
}
