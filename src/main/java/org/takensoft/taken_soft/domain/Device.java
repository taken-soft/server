package org.takensoft.taken_soft.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "devices")
@Getter
@Setter
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "device_id", nullable = false)
    private Integer id;
    
    @Column(name = "device_name")
    private String deviceName;
    
    @OneToMany(mappedBy = "device")
    private Set<Sensor> sensors = new LinkedHashSet<>();
    
    
}