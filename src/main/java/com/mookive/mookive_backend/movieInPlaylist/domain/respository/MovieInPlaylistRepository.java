package com.mookive.mookive_backend.movieInPlaylist.domain.respository;

import com.mookive.mookive_backend.movieInPlaylist.domain.entity.MovieInPlaylist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieInPlaylistRepository extends JpaRepository<MovieInPlaylist, Long> {

    List<MovieInPlaylist> findByPlaylistId(Long playlistId);
}
