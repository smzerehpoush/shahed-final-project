package me.mahdiyar.core.application.models.dto.users.responses;

import lombok.Data;
import me.mahdiyar.core.application.models.common.ServiceResponse;
import me.mahdiyar.core.application.models.dto.users.UserDto;

@Data
public class GetUserResponseDto extends ServiceResponse {
    private final UserDto user;
}
