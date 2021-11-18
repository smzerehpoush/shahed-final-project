package me.mahdiyar.presentation.controllers;

import lombok.RequiredArgsConstructor;
import me.mahdiyar.core.application.exceptions.ApplicationException;
import me.mahdiyar.core.application.models.common.ServiceResponse;
import me.mahdiyar.core.application.models.dto.users.UserDto;
import me.mahdiyar.core.application.models.dto.users.requests.CreateUserRequestDto;
import me.mahdiyar.core.application.models.dto.users.requests.UpdateUserRequestDto;
import me.mahdiyar.core.application.models.dto.users.responses.GetUserResponseDto;
import me.mahdiyar.core.application.models.dto.users.responses.GetUsersResponseDto;
import me.mahdiyar.core.application.models.dto.users.responses.UpdateUserResponseDto;
import me.mahdiyar.core.application.services.user.IUserService;
import me.mahdiyar.core.application.services.user.UserServiceMapper;
import me.mahdiyar.core.domain.entities.UserEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;
    private final UserServiceMapper userServiceMapper;

    @PostMapping
    public UserDto createUser(@RequestBody CreateUserRequestDto request) throws ApplicationException {
        UserEntity user = userService.createUser(request);
        return userServiceMapper.toUserDto(user);
    }

    @GetMapping
    public GetUsersResponseDto getUsers() {
        return userServiceMapper.toGetUsersResponseDto(userService.getUsers());
    }

    @GetMapping("/{userId}")
    public GetUserResponseDto getUser(@PathVariable Long userId) throws ApplicationException {
        return userServiceMapper.toGetUserResponseDto(userService.getUser(userId));
    }

    @PutMapping("/{userId}")
    public UpdateUserResponseDto updateUser(@PathVariable Long userId, @RequestBody UpdateUserRequestDto request) throws ApplicationException {
        return userServiceMapper.toUpdateUserResponseDto(userService.updateUser(userId, request));
    }

    @DeleteMapping("/{userId}")
    public ServiceResponse deleteUser(@PathVariable Long userId) throws ApplicationException {
        userService.deleteUser(userId);
        return new ServiceResponse();
    }
}
