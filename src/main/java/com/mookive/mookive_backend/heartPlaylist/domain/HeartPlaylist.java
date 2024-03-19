package com.mookive.mookive_backend.heartPlaylist.domain;

import com.mookive.mookive_backend.playlist.domain.entity.Playlist;
import com.mookive.mookive_backend.user.domain.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HeartPlaylist {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "playlist_id")
    private Playlist playlist;

    @Builder
    public HeartPlaylist(User user, Playlist playlist) {
        this.user = user;
        this.playlist = playlist;
    }
}

