package me.mahdiyar.core.application.services.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
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
@Log
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserEntity createUser(CreateUserRequestDto request) throws UsernameAlreadyExistsException {
        String username = request.getUsername();
        if (existsByUsername(username)) {
            throw new UsernameAlreadyExistsException();
        }
        UserEntity userEntity = new UserEntity(request.getUsername(), passwordEncoder.encode(request.getPassword()));
        return userRepository.saveAndFlush(userEntity);
    }

    @Override
    public Collection<UserEntity> getUsers() {
        return userRepository.findAllByDeletedFalse();
    }

    @Override
    public UserEntity getUser(long userId) throws UserNotFoundException {
        return userRepository.findByIdAndDeletedFalse(userId).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public UserEntity updateUser(long userId, UpdateUserRequestDto requestDto) throws UserNotFoundException, UsernameAlreadyExistsException {
        UserEntity user = getUser(userId);
        String username = requestDto.getUsername();
        if (existsByUsername(username)) {
            throw new UsernameAlreadyExistsException();
        }
        user.updateUsername(requestDto.getUsername());
        return userRepository.saveAndFlush(user);
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public void deleteUser(long userId) throws UserNotFoundException {
        UserEntity userEntity = getUser(userId);
        userEntity.delete();
        userRepository.delete(userEntity);
    }
}
