package me.mahdiyar.core.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users"
        , indexes = {@Index(unique = true, columnList = "username, deleted")})
public class UserEntity extends BaseEntity {
    @Column(name = "username", unique = true)
    private String username;
    @Column(name = "encoded_password")
    private String encodedPassword;
    @Column(name = "deleted")
    private boolean deleted = false;

    public UserEntity(String username, String hashedPassword) {
        this.username = username;
        this.encodedPassword = hashedPassword;
        this.deleted = false;
    }

    public void updateUsername(String username) {
        this.username = username;
    }

    public void delete() {
        this.deleted = true;
    }
}
