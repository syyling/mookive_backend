package com.mookive.mookive_backend.review.domain.repository;

import com.mookive.mookive_backend.review.domain.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
