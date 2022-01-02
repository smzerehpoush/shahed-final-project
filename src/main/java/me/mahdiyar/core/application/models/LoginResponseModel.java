package me.mahdiyar.core.application.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponseModel {
    private long userId;
    private String token;
    private long expireDate;
}
