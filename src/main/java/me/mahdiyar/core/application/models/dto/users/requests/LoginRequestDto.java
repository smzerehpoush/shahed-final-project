package me.mahdiyar.core.application.models.dto.users.requests;

import lombok.Data;

@Data
public class LoginRequestDto {
    private String username;
    private String password;
}
