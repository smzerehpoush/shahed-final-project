package me.mahdiyar.core.application.services.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.mahdiyar.core.application.exceptions.ApplicationException;
import me.mahdiyar.core.application.exceptions.AuthenticationException;
import me.mahdiyar.core.application.exceptions.ForbiddenActionException;
import me.mahdiyar.core.application.exceptions.users.UserNotFoundException;
import me.mahdiyar.core.application.exceptions.users.UsernameAlreadyExistsException;
import me.mahdiyar.core.application.models.LoginResponseModel;
import me.mahdiyar.core.application.models.dto.users.requests.LoginRequestDto;
import me.mahdiyar.core.application.models.dto.users.requests.SignupRequestDto;
import me.mahdiyar.core.application.models.dto.users.requests.UpdateUserRequestDto;
import me.mahdiyar.core.application.services.user_authentication.UserAuthenticationService;
import me.mahdiyar.core.domain.entities.UserEntity;
import me.mahdiyar.core.domain.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements IUserService {
    private static final String ADMIN_USERNAME = "admin";
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserAuthenticationService userAuthenticationService;

    @Override
    public UserEntity signup(SignupRequestDto request) throws ApplicationException {
        logger.info("trying to sign in user with request {}", request);
        var username = request.getUsername();
        if (existsByUsername(username)) {
            logger.info("user with username {} already exists", username);
            throw new UsernameAlreadyExistsException();
        }
        var userEntity = new UserEntity(request.getUsername(), passwordEncoder.encode(request.getPassword()));
        userEntity = userRepository.saveAndFlush(userEntity);
        logger.info("user created successfully with id {}", userEntity.getId());
        return userEntity;
    }

    @Override
    public Collection<UserEntity> getUsers() {
        logger.info("trying to get users");
        return userRepository.findAllByDeletedFalse();
    }

    @Override
    public UserEntity getUser(long userId) throws ApplicationException {
        logger.info("trying to get user with id {}", userId);
        return userRepository.findByIdAndDeletedFalse(userId).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public UserEntity updateUser(long userId, UpdateUserRequestDto request) throws ApplicationException {
        logger.info("trying to update user with userId {} and request {}", userId, request);
        if (ADMIN_USERNAME.equals(request.getUsername()))
            throw new ForbiddenActionException();
        var user = getUser(userId);
        var username = request.getUsername();
        if (existsByUsername(username)) {
            throw new UsernameAlreadyExistsException();
        }
        user.updateUsername(request.getUsername());
        return userRepository.saveAndFlush(user);
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public void deleteUser(long userId) throws ApplicationException {

        logger.info("trying to delete user with id {}", userId);
        var userEntity = getUser(userId);
        userEntity.delete();
        userRepository.delete(userEntity);
        logger.info("user with userId {} deleted successfully", userId);
    }

    @Override
    public LoginResponseModel login(LoginRequestDto request) throws ApplicationException {
        logger.info("trying to login with username {}", request.getUsername());
        var user = userRepository.findByUsernameAndDeletedFalse(request.getUsername()).orElseThrow(UserNotFoundException::new);
        if (!passwordEncoder.matches(request.getPassword(), user.getEncodedPassword()))
            throw new AuthenticationException();
        var tokenPair = userAuthenticationService.createTokenForUser(user);
        return new LoginResponseModel(user.getId(), tokenPair.getFirst(), tokenPair.getSecond().getExpireDate().getTime());
    }

}
