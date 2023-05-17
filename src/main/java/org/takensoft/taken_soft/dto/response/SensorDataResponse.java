package org.takensoft.taken_soft.dto.response;

import lombok.Data;
import org.takensoft.taken_soft.dto.RealtimeSensorData;

import java.util.ArrayList;
import java.util.List;


/**
 *  주기적으로 응답할 센서 데이터 응답 객체
 *
 */
@Data
public class SensorDataResponse {
    private List<RealtimeSensorData> realtimeSensorDataList=new ArrayList<>();
}
