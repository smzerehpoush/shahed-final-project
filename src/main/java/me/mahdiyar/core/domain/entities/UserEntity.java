package me.mahdiyar.core.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "username", unique = true)
    private String username;
    @Column(name = "hashed_password")
    private String hashedPassword;
    @Column(name = "deleted")
    private boolean deleted = false;

    public UserEntity(String username, String hashedPassword) {
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.deleted = false;
    }

    public void updateUsername(String username) {
        this.username = username;
    }

    public void delete() {
        this.deleted = true;
    }
}
