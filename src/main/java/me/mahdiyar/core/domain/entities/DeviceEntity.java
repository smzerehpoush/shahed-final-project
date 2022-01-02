package me.mahdiyar.core.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "devices")
public class DeviceEntity extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "device_id")
    private long userDeviceId;
    @Column(name = "deleted", columnDefinition = "boolean default false")
    private boolean deleted;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DeviceEntity that = (DeviceEntity) o;
        return userDeviceId == that.userDeviceId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), userDeviceId);
    }
}
