package me.mahdiyar.core.application.models.dto.users.responses;

import lombok.Data;
import me.mahdiyar.core.application.models.dto.users.UserDto;

@Data
public class UpdateUserResponseDto {
    private final UserDto user;
}
