package com.mookive.mookive_backend.review.domain.entity;


import com.mookive.mookive_backend.movie.domain.entity.Movie;
import com.mookive.mookive_backend.user.domain.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rating;
    private String text;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @Builder
    public Review(String rating, String text, LocalDate date, User user, Movie movie) {
        this.rating = rating;
        this.text = text;
        this.date = date;
        this.user = user;
        this.movie = movie;
    }

    public void updateReview(String rating, String text, LocalDate date) {
        this.rating = rating;
        this.text = text;
        this.date = date;
    }
}
