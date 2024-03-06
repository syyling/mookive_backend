package com.mookive.mookive_backend.keyword.domain.repository;

import com.mookive.mookive_backend.keyword.domain.entity.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeywordRepository extends JpaRepository<Keyword, Long> {
}
