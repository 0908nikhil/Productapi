package com.example.productapi.repository;

import com.example.productapi.entity.RefreshToken;
import com.example.productapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    // 🔍 Find by token (used during refresh)
    Optional<RefreshToken> findByToken(String token);

    // 🔍 Find token by user (for rotation logic)
    Optional<RefreshToken> findByUser(User user);

    // 🗑️ Delete token by user (important for rotation)
    void deleteByUser(User user);
}