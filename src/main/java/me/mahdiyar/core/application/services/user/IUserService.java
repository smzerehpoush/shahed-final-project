package me.mahdiyar.core.application.services.user;

import me.mahdiyar.core.application.exceptions.users.UserNotFoundException;
import me.mahdiyar.core.application.exceptions.users.UsernameAlreadyExistsException;
import me.mahdiyar.core.application.models.dto.users.requests.CreateUserRequestDto;
import me.mahdiyar.core.application.models.dto.users.requests.UpdateUserRequestDto;
import me.mahdiyar.core.domain.entities.UserEntity;

import java.util.Collection;

public interface IUserService {
    UserEntity createUser(CreateUserRequestDto request) throws UsernameAlreadyExistsException;

    Collection<UserEntity> getUsers();

    UserEntity getUser(long userId) throws UserNotFoundException;

    UserEntity updateUser(long userId, UpdateUserRequestDto requestDto) throws UserNotFoundException, UsernameAlreadyExistsException;

    void deleteUser(long userId) throws UserNotFoundException;
}
