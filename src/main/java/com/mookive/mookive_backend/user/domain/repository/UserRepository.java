package com.mookive.mookive_backend.user.domain.repository;

import com.mookive.mookive_backend.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
