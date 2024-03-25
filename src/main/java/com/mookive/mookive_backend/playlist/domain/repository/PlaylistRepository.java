package com.mookive.mookive_backend.playlist.domain.repository;

import com.mookive.mookive_backend.playlist.domain.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {

    void deleteById(Long playlistId);
}
