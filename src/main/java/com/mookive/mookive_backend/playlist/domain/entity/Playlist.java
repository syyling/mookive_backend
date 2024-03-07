package com.mookive.mookive_backend.playlist.domain.entity;

import com.mookive.mookive_backend.user.domain.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Playlist {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Playlist(String name, User user) {
        this.name = name;
        this.user = user;
    }
}
