package me.mahdiyar.core.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "device_data")
@NoArgsConstructor
public class DeviceDataEntity extends BaseEntity {
    @Column(name = "device_id")
    private long deviceId;
    @Column(name = "latitude")
    private String latitude;
    @Column(name = "longitude")
    private String longitude;
    @Column(name = "altitude")
    private int altitude;
    @Column(name = "sampling_date")
    private long samplingDate;
    @Column(name = "bts_latitude")
    private String btsLatitude;
    @Column(name = "bts_longitude")
    private String btsLongitude;
    @Column(name = "battrey")
    private int battrey;
}
