package me.mahdiyar.core.application.models.dto.users.requests;

import lombok.Data;
import me.mahdiyar.core.application.models.common.ServiceRequest;
import org.springframework.lang.NonNull;

@Data
public class SignupRequestDto extends ServiceRequest {
    @NonNull
    private String username;
    @NonNull
    private String password;

    @Override
    public String toString() {
        return "CreateUserRequestDto{" +
                "username='" + username + '\'' +
                ", password= *** }";
    }
}
