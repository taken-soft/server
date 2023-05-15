package org.takensoft.taken_soft.dto;

import lombok.Data;

/**
 * package :  org.takensoft.taken_soft.dto
 * fileName : SensorDataRequest
 * author :  ShinYeaChan
 * date : 2023-05-15
 */
@Data
public class RequestedSensorData {
    private String sensorId;
    private boolean isGraph;
}
