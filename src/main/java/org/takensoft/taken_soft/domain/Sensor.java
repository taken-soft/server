package org.takensoft.taken_soft.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "sensors")
@Getter
@Setter
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sensor_id", nullable = false)
    private Integer id;
    
    @Column(name = "sensor_name")
    private String sensorName;
    
    @Column(name = "sensor_unit", length = 40)
    private String sensorUnit;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "device_id", nullable = false)
    private Device device;
    
    @OneToMany(mappedBy = "sensor")
    Set<SensorData> sensorData=new LinkedHashSet<>();
}