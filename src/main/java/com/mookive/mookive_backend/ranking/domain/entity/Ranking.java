package com.mookive.mookive_backend.ranking.domain.entity;

import com.mookive.mookive_backend.movie.domain.entity.Movie;
import com.mookive.mookive_backend.user.domain.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Ranking {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private int rankingNumber;

    @Builder
    public Ranking(Movie movie, User user, int rankingNumber) {
        this.movie = movie;
        this.user = user;
        this.rankingNumber = rankingNumber;
    }
}
