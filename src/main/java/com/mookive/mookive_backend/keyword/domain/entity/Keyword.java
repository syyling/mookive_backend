package com.mookive.mookive_backend.keyword.domain.entity;

import com.mookive.mookive_backend.review.domain.entity.Review;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Keyword {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "review_id")
    private Review review;

    private String word;

    @Builder
    public Keyword(Review review, String word) {
        this.review = review;
        this.word = word;
    }
}
