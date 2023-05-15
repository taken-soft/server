package org.takensoft.taken_soft.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SensorDto {
    private Integer id;
    private String sensorName;
    private String sensorUnit;
}



