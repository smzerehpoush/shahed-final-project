package me.mahdiyar.core.application.models.dto.users.responses;

import lombok.Data;
import me.mahdiyar.core.application.models.common.ServiceResponse;

@Data
public class LoginResponseDto extends ServiceResponse {
    private long userId;
    private String token;
    private long expireDate;
}
