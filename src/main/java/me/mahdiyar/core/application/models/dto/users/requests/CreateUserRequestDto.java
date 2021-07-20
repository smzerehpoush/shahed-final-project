package me.mahdiyar.core.application.models.dto.users.requests;

import lombok.Data;

@Data
public class CreateUserRequestDto {
    private String username;
    private String password;
}
