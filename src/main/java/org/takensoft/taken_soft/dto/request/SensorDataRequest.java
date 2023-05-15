package org.takensoft.taken_soft.dto.request;

import lombok.Data;
import org.takensoft.taken_soft.dto.RequestedSensorData;

import java.util.ArrayList;
import java.util.List;

/**
 * package :  org.takensoft.taken_soft.dto
 * fileName : SensorDataRequest
 * author :  ShinYeaChan
 * date : 2023-05-15
 */
@Data
public class SensorDataRequest {
    List<RequestedSensorData> sensorDataList=new ArrayList<>();
}
