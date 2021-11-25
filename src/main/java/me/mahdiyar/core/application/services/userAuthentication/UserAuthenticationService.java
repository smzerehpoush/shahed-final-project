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

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserAuthenticationService implements IUserAuthenticationService {
    private final PasswordEncoder encoder;
    private final TokenRepository tokenRepository;

    @Override
    public Pair<String, TokenEntity> createTokenForUser(UserEntity user) {
        var plainToken = generateSafeToken();
        var hashedToken = HashGenerator.generateHash(plainToken);
        var tokenEntity = new TokenEntity(hashedToken, createTokenExpireDate(), user);
        tokenRepository.save(tokenEntity);
        return Pair.of(plainToken, tokenEntity);
    }

    private String generateSafeToken() {
        var random = new SecureRandom();
        var bytes = new byte[128];
        random.nextBytes(bytes);
        var encoder = Base64.getUrlEncoder().withoutPadding();
        return encoder.encodeToString(bytes);
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
