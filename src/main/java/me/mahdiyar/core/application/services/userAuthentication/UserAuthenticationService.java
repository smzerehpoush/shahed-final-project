package me.mahdiyar.core.application.services.userAuthentication;

import lombok.RequiredArgsConstructor;
import me.mahdiyar.core.application.common.HashGenerator;
import me.mahdiyar.core.application.models.common.AuthenticatedUser;
import me.mahdiyar.core.domain.entities.TokenEntity;
import me.mahdiyar.core.domain.entities.UserEntity;
import me.mahdiyar.core.domain.repositories.TokenRepository;
import org.springframework.data.util.Pair;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserAuthenticationService implements IUserAuthenticationService {
    private final PasswordEncoder encoder;
    private final TokenRepository tokenRepository;

    @Override
    public Pair<String, TokenEntity> createTokenForUser(UserEntity user) {
        var plainToken = UUID.randomUUID().toString();
        var hashedToken = HashGenerator.generateHash(plainToken);
        var tokenEntity = new TokenEntity(hashedToken, createTokenExpireDate(), user);
        tokenRepository.save(tokenEntity);
        return Pair.of(plainToken, tokenEntity);
    }

    @Override
    public Optional<UserDetails> findByToken(String plainToken) {
        var hashedToken = HashGenerator.generateHash(plainToken);
        var optionalToken = tokenRepository.findByHashedToken(hashedToken);
        if (optionalToken.isEmpty())
            return Optional.empty();
        var authenticatedUser = new AuthenticatedUser(optionalToken.get().getUser().getUsername(), plainToken);
        return Optional.of(authenticatedUser);
    }

    private Date createTokenExpireDate() {
        var now = new Date();
        var calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.MONTH, 1);
        return calendar.getTime();
    }
}
