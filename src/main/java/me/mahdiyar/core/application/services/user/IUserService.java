package me.mahdiyar.core.application.services.user;

import me.mahdiyar.core.application.exceptions.ApplicationException;
import me.mahdiyar.core.application.models.domainModels.user.LoginResponseModel;
import me.mahdiyar.core.application.models.dto.users.requests.LoginRequestDto;
import me.mahdiyar.core.application.models.dto.users.requests.SignupRequestDto;
import me.mahdiyar.core.application.models.dto.users.requests.UpdateUserRequestDto;
import me.mahdiyar.core.domain.entities.UserEntity;

import java.util.Collection;

public interface IUserService {
    UserEntity signup(SignupRequestDto request) throws ApplicationException;

    Collection<UserEntity> getUsers();

    UserEntity getUser(long userId) throws ApplicationException;

    UserEntity updateUser(long userId, UpdateUserRequestDto requestDto) throws ApplicationException;

    void deleteUser(long userId) throws ApplicationException;

    LoginResponseModel login(LoginRequestDto request) throws ApplicationException;
}
