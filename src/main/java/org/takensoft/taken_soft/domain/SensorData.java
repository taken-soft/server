package org.takensoft.taken_soft.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Entity
@Table(name = "sensor_data")
@Getter@Setter
public class SensorData {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "sensor_data_id", nullable = false)
    private UUID id;
    
    @Column(name = "sensor_data_value", length = 40)
    private String sensorDataValue;
    
    @Column(name = "sensor_data_time")
    private ZonedDateTime sensorDataTime;
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "sensor_id", nullable = false)
    private Sensor sensor;
}