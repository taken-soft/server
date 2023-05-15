package org.takensoft.taken_soft.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "layout_widget_sensor")
@Getter
@Setter
public class LayoutWidgetSensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "layout_widget_sensor_id", nullable = false)
    private Integer id;
    
    @Column(name = "layout_widget_sensor_sequence")
    private Integer layoutWidgetSensorSequence;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "layout_widget_id", nullable = false)
    private LayoutWidget layoutWidget;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sensor_id", nullable = false)
    private Sensor sensor;

    
}