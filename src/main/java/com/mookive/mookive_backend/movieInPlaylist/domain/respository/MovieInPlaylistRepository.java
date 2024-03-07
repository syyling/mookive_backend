package com.mookive.mookive_backend.movieInPlaylist.domain.respository;

import com.mookive.mookive_backend.movieInPlaylist.domain.entity.MovieInPlaylist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieInPlaylistRepository extends JpaRepository<MovieInPlaylist, Long> {
}
