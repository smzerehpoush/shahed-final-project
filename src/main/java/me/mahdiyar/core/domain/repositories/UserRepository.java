package me.mahdiyar.core.domain.repositories;

import me.mahdiyar.core.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByIdAndDeletedFalse(long userId);

    Collection<UserEntity> findAllByDeletedFalse();

    Optional<UserEntity> findByUsernameAndDeletedFalse(String username);

    boolean existsByUsername(String username);
}
