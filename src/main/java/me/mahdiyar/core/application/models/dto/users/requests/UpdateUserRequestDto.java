package me.mahdiyar.core.application.models.dto.users.requests;

import lombok.Data;
import me.mahdiyar.core.application.models.common.ServiceRequest;

@Data
public class UpdateUserRequestDto extends ServiceRequest {
    private String username;
}
