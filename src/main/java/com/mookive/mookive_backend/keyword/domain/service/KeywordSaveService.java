package com.mookive.mookive_backend.keyword.domain.service;

import com.mookive.mookive_backend.keyword.domain.entity.Keyword;
import com.mookive.mookive_backend.keyword.domain.repository.KeywordRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class KeywordSaveService {

    private final KeywordRepository keywordRepository;

    public void saveKeyword(Keyword keyword) {
        keywordRepository.save(keyword);
    }
}
