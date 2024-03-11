package com.mookive.mookive_backend.keyword.domain.service;

import com.mookive.mookive_backend.keyword.domain.entity.Keyword;
import com.mookive.mookive_backend.keyword.domain.repository.KeywordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KeywordQueryService {

    private final KeywordRepository keywordRepository;

    public List<Keyword> findByReviewId(Long reviewId) {
        return keywordRepository.findByReviewId(reviewId);
    }
}
