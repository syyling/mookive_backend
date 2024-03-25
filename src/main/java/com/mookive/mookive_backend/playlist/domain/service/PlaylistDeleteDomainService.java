package com.mookive.mookive_backend.playlist.domain.service;

import com.mookive.mookive_backend.playlist.domain.repository.PlaylistRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


/**
 * 추후 domain, application 서비스 구분 annotation으로 변경 예정
 */
@Service
@RequiredArgsConstructor
@Transactional
public class PlaylistDeleteDomainService {

    private final PlaylistRepository playlistRepository;

    public void deleteById(Long playlistId) {
        playlistRepository.deleteById(playlistId);
    }
}
