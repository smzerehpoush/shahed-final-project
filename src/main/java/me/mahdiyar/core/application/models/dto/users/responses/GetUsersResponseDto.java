package me.mahdiyar.core.application.models.dto.users.responses;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import me.mahdiyar.core.application.models.common.ServiceResponse;
import me.mahdiyar.core.application.models.dto.users.UserDto;

import java.util.Collection;

@Data
@RequiredArgsConstructor
public class GetUsersResponseDto extends ServiceResponse {
    private final Collection<UserDto> users;
}
