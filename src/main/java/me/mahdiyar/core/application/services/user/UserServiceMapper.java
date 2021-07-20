package me.mahdiyar.core.application.services.user;

import me.mahdiyar.core.application.models.dto.users.UserDto;
import me.mahdiyar.core.application.models.dto.users.responses.GetUserResponseDto;
import me.mahdiyar.core.application.models.dto.users.responses.GetUsersResponseDto;
import me.mahdiyar.core.application.models.dto.users.responses.UpdateUserResponseDto;
import me.mahdiyar.core.domain.entities.UserEntity;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface UserServiceMapper {
    UserDto toUserDto(UserEntity model);

    Collection<UserDto> toUserDtoCollection(Collection<UserEntity> model);

    default GetUsersResponseDto toGetUsersResponseDto(Collection<UserEntity> users) {
        return new GetUsersResponseDto(toUserDtoCollection(users));
    }

    default GetUserResponseDto toGetUserResponseDto(UserEntity user) {
        return new GetUserResponseDto(toUserDto(user));
    }

    default UpdateUserResponseDto toUpdateUserResponseDto(UserEntity user) {
        return new UpdateUserResponseDto(toUserDto(user));
    }
}
