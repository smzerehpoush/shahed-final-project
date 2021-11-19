package me.mahdiyar.core.application.services.userAuthentication;

import me.mahdiyar.core.domain.entities.TokenEntity;
import me.mahdiyar.core.domain.entities.UserEntity;
import org.springframework.data.util.Pair;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface IUserAuthenticationService {
    Pair<String, TokenEntity> createTokenForUser(UserEntity user);

    Optional<UserDetails> findByToken(String token);

}
