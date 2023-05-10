package org.takensoft.taken_soft.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Entity
@Table(name = "sensor_data")
@Getter@Setter
public class SensorData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sensor_data_id", nullable = false)
    private Integer id;
    
    @Column(name = "sensor_data_value", length = 40)
    private String sensorDataValue;
    
    @Column(name = "sensor_data_time")
    private ZonedDateTime sensorDataTime;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sensor_id", nullable = false)
    private Sensor sensor;
}