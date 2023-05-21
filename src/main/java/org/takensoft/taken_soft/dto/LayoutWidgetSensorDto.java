package org.takensoft.taken_soft.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.takensoft.taken_soft.domain.LayoutWidgetSensor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class LayoutWidgetSensorDto {
    private Integer layoutWidgetSensorId;
    private Integer layoutWidgetSensorSequence;
    private SensorDto sensorDTO;
    public LayoutWidgetSensorDto(LayoutWidgetSensor layoutWidgetSensor,SensorDto sensorDTO){
        LayoutWidgetSensorDto.of(layoutWidgetSensor.getId(),layoutWidgetSensor.getLayoutWidgetSensorSequence(),sensorDTO);
    }
}
