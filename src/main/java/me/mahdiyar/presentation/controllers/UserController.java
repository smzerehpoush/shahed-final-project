package me.mahdiyar.presentation.controllers;

import lombok.RequiredArgsConstructor;
import me.mahdiyar.core.application.exceptions.ApplicationException;
import me.mahdiyar.core.application.models.LoginResponseModel;
import me.mahdiyar.core.application.models.common.ServiceResponse;
import me.mahdiyar.core.application.models.dto.users.UserDto;
import me.mahdiyar.core.application.models.dto.users.requests.LoginRequestDto;
import me.mahdiyar.core.application.models.dto.users.requests.SignupRequestDto;
import me.mahdiyar.core.application.models.dto.users.requests.UpdateUserRequestDto;
import me.mahdiyar.core.application.models.dto.users.responses.GetUsersResponseDto;
import me.mahdiyar.core.application.models.dto.users.responses.LoginResponseDto;
import me.mahdiyar.core.application.models.dto.users.responses.SignInResponseDto;
import me.mahdiyar.core.application.models.dto.users.responses.UpdateUserResponseDto;
import me.mahdiyar.core.application.services.user.IUserService;
import me.mahdiyar.core.application.services.user.UserServiceMapper;
import me.mahdiyar.core.domain.entities.UserEntity;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/users/")
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;
    private final UserServiceMapper userServiceMapper;
    private static final String AUTHORIZATION_HEADER = "Authorization";

    @PostMapping("login")
    public LoginResponseDto login(@RequestBody LoginRequestDto request) throws ApplicationException {
        LoginResponseModel logingResponseModel = userService.login(request);
        return userServiceMapper.toLoginResponseDto(logingResponseModel);
    }

    @PostMapping("signup")
    public SignInResponseDto signup(@RequestBody SignupRequestDto request) throws ApplicationException {
        UserEntity user = userService.signup(request);
        return userServiceMapper.toSignupResponseDto(user);
    }

    @GetMapping
    public GetUsersResponseDto getUsers() {
        Collection<UserEntity> users = userService.getUsers();
        return userServiceMapper.toGetUsersResponseDto(users);
    }

    @GetMapping("/{userId}")
    public SignInResponseDto getUser(@PathVariable Long userId) throws ApplicationException {
        UserEntity user = userService.getUser(userId);
        return userServiceMapper.toSignupResponseDto(user);
    }

    @PutMapping("/{userId}")
    public UpdateUserResponseDto updateUser(@PathVariable Long userId, @RequestBody UpdateUserRequestDto request) throws ApplicationException {
        UserEntity user = userService.updateUser(userId, request);
        return userServiceMapper.toUpdateUserResponseDto(user);
    }


    @GetMapping("info")
    public UserDto getUserInfo(HttpServletRequest request) throws ApplicationException {
        var token = Optional.ofNullable(request.getHeader(AUTHORIZATION_HEADER))
                .orElseThrow(() -> new AuthenticationCredentialsNotFoundException("authorization header is not present"))
                .replace("Bearer ", "")
                .replace("bearer ", "")
                .trim();

        UserEntity user = userService.getUserInfo(token);
        return userServiceMapper.toUserDto(user);
    }

    @DeleteMapping("/{userId}")
    public ServiceResponse deleteUser(@PathVariable Long userId) throws ApplicationException {
        userService.deleteUser(userId);
        return new ServiceResponse();
    }
}
