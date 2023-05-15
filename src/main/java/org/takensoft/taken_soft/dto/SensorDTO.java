package org.takensoft.taken_soft.dto;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.takensoft.taken_soft.domain.Device;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SensorDTO {
    private Integer id;
    private String sensorName;
    private String sensorUnit;
}



