package org.takensoft.taken_soft.dto;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.takensoft.taken_soft.domain.LayoutWidget;
import org.takensoft.taken_soft.domain.Sensor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LayoutWidgetSensorDTO {
    private Integer id;
    private Integer layoutWidgetSensorSequence;

    private SensorDTO sensorDTO;
}
