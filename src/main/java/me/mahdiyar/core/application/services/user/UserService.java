package me.mahdiyar.core.application.services.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.mahdiyar.core.application.exceptions.users.UserNotFoundException;
import me.mahdiyar.core.application.exceptions.users.UsernameAlreadyExistsException;
import me.mahdiyar.core.application.models.dto.users.requests.CreateUserRequestDto;
import me.mahdiyar.core.application.models.dto.users.requests.UpdateUserRequestDto;
import me.mahdiyar.core.domain.entities.UserEntity;
import me.mahdiyar.core.domain.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserEntity createUser(CreateUserRequestDto request) throws UsernameAlreadyExistsException {
        logger.info("trying to create user with request {}", request);
        String username = request.getUsername();
        if (existsByUsername(username)) {
            logger.info("user with username {} already exists", username);
            throw new UsernameAlreadyExistsException();
        }
        UserEntity userEntity = new UserEntity(request.getUsername(), passwordEncoder.encode(request.getPassword()));
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
    public UserEntity getUser(long userId) throws UserNotFoundException {
        logger.info("trying to get user with id {}", userId);
        return userRepository.findByIdAndDeletedFalse(userId).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public UserEntity updateUser(long userId, UpdateUserRequestDto request) throws UserNotFoundException, UsernameAlreadyExistsException {
        logger.info("trying to update user with userId {} and request {}", userId, request);
        UserEntity user = getUser(userId);
        String username = request.getUsername();
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
    public void deleteUser(long userId) throws UserNotFoundException {
        logger.info("trying to delete user with id {}", userId);
        UserEntity userEntity = getUser(userId);
        userEntity.delete();
        userRepository.delete(userEntity);
        logger.info("user with userId {} deleted successfully", userId);
    }
}
