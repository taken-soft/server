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
    private Integer sensorId;

    // 그래프 getter와 변수명이 일치하여 충돌발생. 따라서 graph로 수정함.
    private boolean graph;
}
