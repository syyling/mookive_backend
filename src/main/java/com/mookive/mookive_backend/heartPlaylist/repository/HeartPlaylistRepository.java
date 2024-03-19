package com.mookive.mookive_backend.heartPlaylist.repository;

import com.mookive.mookive_backend.heartPlaylist.domain.HeartPlaylist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeartPlaylistRepository extends JpaRepository<HeartPlaylist, Long> {

    HeartPlaylist findByUserId(Long userId);

}
