package me.mahdiyar.core.application.models.domainModels.user;

import lombok.Data;

@Data
public class LoginResponseModel {
    private String token;
    private long expireDate;

    public LoginResponseModel(String token, long expireDate) {
        this.token = token;
        this.expireDate = expireDate;
    }
}
