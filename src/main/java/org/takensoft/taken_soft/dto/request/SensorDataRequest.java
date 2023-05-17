package org.takensoft.taken_soft.dto.request;

import lombok.Data;
import org.takensoft.taken_soft.dto.RequestedSensorData;

import java.util.ArrayList;
import java.util.List;


/**
 *  요청할 센서데이터들을 받을 요청 객체
 *
 */
@Data
public class SensorDataRequest {
    List<RequestedSensorData> sensorDataList=new ArrayList<>();
}
