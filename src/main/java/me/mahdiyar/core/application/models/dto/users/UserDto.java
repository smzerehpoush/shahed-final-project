package me.mahdiyar.core.application.models.dto.users;

import lombok.Data;

import java.util.UUID;

@Data
public class UserDto {
    private long id;
    private UUID uniqueId;
    private String username;
}
