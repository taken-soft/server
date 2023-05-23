package org.takensoft.taken_soft.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.takensoft.taken_soft.domain.LayoutWidgetSensor;

@Data
@Slf4j
@NoArgsConstructor
public class LayoutWidgetSensorDto {
    private Integer layoutWidgetSensorId;//
    private Integer layoutWidgetSensorSequence;
    private Integer sensorId;
    
    public LayoutWidgetSensorDto(LayoutWidgetSensor layoutWidgetSensor) {
        this.layoutWidgetSensorSequence=layoutWidgetSensor.getLayoutWidgetSensorSequence();
        this.layoutWidgetSensorId=layoutWidgetSensor.getId();
        this.sensorId=layoutWidgetSensor.getSensor().getId();
    }
    
    public static LayoutWidgetSensorDto of(LayoutWidgetSensor layoutWidgetSensor) {
        return new LayoutWidgetSensorDto(layoutWidgetSensor);
    }
}
