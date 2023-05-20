package org.takensoft.taken_soft.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.takensoft.taken_soft.domain.Sensor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class SensorDto {
    private Integer id;
    private String sensorName;
    private String sensorUnit;
    public SensorDto(Sensor sensor){
        SensorDto.of(sensor.getId(), sensor.getSensorName(),sensor.getSensorUnit());
    }
}



