package me.mahdiyar.configuration.security;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class TokenBasedAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private static final String AuthorizationHeader = "Authorization";

    public TokenBasedAuthenticationFilter(RequestMatcher requiresAuthenticationRequestMatcher) {
        super(requiresAuthenticationRequestMatcher);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        SecurityContextHolder.getContext().setAuthentication(authResult);
        chain.doFilter(request, response);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException {
        var token = Optional.ofNullable(httpServletRequest.getHeader(AuthorizationHeader))
                .orElseThrow(() -> new AuthenticationCredentialsNotFoundException("authorization header is not present"))
                .replace("Bearer ", "")
                .replace("bearer ", "")
                .trim();
        var authenticationRequest = new UsernamePasswordAuthenticationToken(token, token);
        return getAuthenticationManager().authenticate(authenticationRequest);
    }
}
