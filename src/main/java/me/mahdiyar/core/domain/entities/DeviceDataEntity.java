package me.mahdiyar.core.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

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
    @Column(name = "temperature")
    private double temperature;
    @Column(name = "humidity")
    private double humidity;

    public DeviceDataEntity(long deviceId, String latitude, String longitude, int altitude, long samplingDate, String btsLatitude, String btsLongitude, int battrey, double temperature, double humidity) {
        this.deviceId = deviceId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.samplingDate = samplingDate;
        this.btsLatitude = btsLatitude;
        this.btsLongitude = btsLongitude;
        this.battrey = battrey;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DeviceDataEntity that = (DeviceDataEntity) o;
        return deviceId == that.deviceId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), deviceId);
    }
}
