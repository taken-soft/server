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
    // 센서 아이디
    private Integer sensorId;
    // 센서 아이디에 해당하는 값 (그래프의 경우 5개의 값-시간 Value를 가질 수 있음)
    private List<SensorValue> SensorValues=new ArrayList<>();
}
