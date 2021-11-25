package me.mahdiyar.core.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

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
    @Column(name = "deleted", nullable = false, columnDefinition = "boolean default false")
    private boolean deleted;
    @Column(name = "is_admin", nullable = false, columnDefinition = "boolean default false")
    private boolean isAdmin;
    @OneToMany(fetch = FetchType.LAZY, targetEntity = DeviceEntity.class, mappedBy = "user")
    private Set<DeviceEntity> devices;

    public UserEntity(String username, String hashedPassword) {
        this.username = username;
        this.encodedPassword = hashedPassword;
        this.deleted = false;
        this.isAdmin = false;
    }

    public void updateUsername(String username) {
        this.username = username;
    }

    public void delete() {
        this.deleted = true;
    }
}
