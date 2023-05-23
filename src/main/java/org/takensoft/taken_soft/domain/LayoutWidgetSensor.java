package org.takensoft.taken_soft.domain;

import jakarta.persistence.*;
import lombok.*;
import org.takensoft.taken_soft.dto.LayoutWidgetSensorDto;

@Entity
@Table(name = "layout_widget_sensor")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LayoutWidgetSensor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "layout_widget_sensor_id", nullable = false)
    private Integer id;
    
    @Column(name = "layout_widget_sensor_sequence")
    private Integer layoutWidgetSensorSequence;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "layout_widget_id", nullable = false)
    @ToString.Exclude
    private LayoutWidget layoutWidget;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sensor_id", nullable = false)
    @ToString.Exclude
    private Sensor sensor;
    
    public static LayoutWidgetSensor ofDto(LayoutWidgetSensorDto layoutWidgetSensorDto) {
        return new LayoutWidgetSensor(layoutWidgetSensorDto);
    }
    
    public LayoutWidgetSensor(LayoutWidgetSensorDto layoutWidgetSensorDto) {
        this.layoutWidgetSensorSequence = layoutWidgetSensorDto.getLayoutWidgetSensorSequence();
    }
}