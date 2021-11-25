package me.mahdiyar.core.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
}
