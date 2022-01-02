package me.mahdiyar.configuration.security;

import lombok.RequiredArgsConstructor;
import me.mahdiyar.core.application.services.user_authentication.IUserAuthenticationService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TokenBasedAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
    private final IUserAuthenticationService userAuthenticationService;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        // no additional authentication check required
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        var token = authentication.getCredentials();
        return Optional
                .ofNullable(token)
                .map(String::valueOf)
                .flatMap(userAuthenticationService::findByToken)
                .orElseThrow(() -> new UsernameNotFoundException("can not find user with token " + token));
    }
}
