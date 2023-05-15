package org.takensoft.taken_soft.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * package :  org.takensoft.taken_soft.dto.response
 * fileName : SensorDataResponse
 * author :  ShinYeaChan
 * date : 2023-05-15
 */
@Data
public class RealtimeSensorData {
    private String sensorId;
    private List<SensorValue> values=new ArrayList<>();
}
