package me.mahdiyar.core.domain.repositories;

import me.mahdiyar.core.domain.entities.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<TokenEntity, Long> {
    Optional<TokenEntity> findByHashedToken(String hashedToken);
}
