package com.mookive.mookive_backend.keyword.domain.repository;

import com.mookive.mookive_backend.keyword.domain.entity.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KeywordRepository extends JpaRepository<Keyword, Long> {

    List<Keyword> findByReviewId(Long reviewId);

    void deleteAllByReviewId(Long reviewId);
}
