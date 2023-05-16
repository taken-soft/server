package org.takensoft.taken_soft.dto.response;

import lombok.Data;
import org.takensoft.taken_soft.dto.RealtimeSensorData;

import java.util.ArrayList;
import java.util.List;

/**
 * package :  org.takensoft.taken_soft.dto.response
 * fileName : SensorDataResponse
 * author :  ShinYeaChan
 * date : 2023-05-15
 */
@Data
public class SensorDataResponse {

    // 여러개의 (센서와 그에 대한 센서데이터들) 에 대한 최종 반환.
    private List<RealtimeSensorData> realtimeSensorDataList=new ArrayList<>();
}
