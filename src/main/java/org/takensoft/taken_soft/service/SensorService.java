package org.takensoft.taken_soft.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.takensoft.taken_soft.api.SensorController;
import org.takensoft.taken_soft.domain.SensorData;
import org.takensoft.taken_soft.dto.RealtimeSensorData;
import org.takensoft.taken_soft.dto.RequestedSensorData;
import org.takensoft.taken_soft.dto.SensorValue;
import org.takensoft.taken_soft.dto.request.SensorDataRequest;
import org.takensoft.taken_soft.dto.response.SensorDataResponse;
import org.takensoft.taken_soft.repository.SensorRepository;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    public SensorDataResponse getSensorData(SensorDataRequest sensorDataRequest){

        /** 1. RequestSensorData 리스트 가져옴 */
        List<RequestedSensorData> requestedSensorDataList = sensorDataRequest.getSensorDataList();

        /** 2. 반환할 객체(Response) 제작 */
        SensorDataResponse sensorDataResponse = new SensorDataResponse();

        /** 3. 반복문을 돌며 검사 */
        for (RequestedSensorData requestedSensorData : requestedSensorDataList) {
            Integer sensorId = requestedSensorData.getSensorId();
            boolean graph = requestedSensorData.isGraph();
            log.info("센서 아이디: {}", sensorId);
            log.info("그래프 유무: {}", graph);


            /** 4. realtimeSensorData 생성 */
            RealtimeSensorData realtimeSensorData = new RealtimeSensorData();
            /** 5. 센서 id 할당 */
            realtimeSensorData.setSensorId(sensorId);


            /** 6. 센서 value 할당 */
            // 그래프인 경우
            if(graph){

                // TODO : 센서 value list가 5개
                // 센서 데이터를 1분 단위로 뒤에서부터 5개를 가져옴
                // 마지막 센서 데이터를 가져옴
                SensorData lastSensorData = sensorRepository.findLastSensorDataBySensorId(sensorId);
                // 마지막 센서 데이터의 시간을 가져옴
                ZonedDateTime lastSensorDataTime = lastSensorData.getSensorDataTime();
                // -1분, -2분, -3분, -4분의 시간 계산
                List<ZonedDateTime> timeList = new ArrayList<>();
                for (int i = 1; i <= 4; i++) {
//                    timeList.add(lastSensorDataTime.minusMinutes(i));
                    timeList.add(lastSensorDataTime.minusSeconds(i));
                }

                List<SensorData> sensorDataList = new ArrayList<>();
                sensorDataList.add(lastSensorData);
                // 시간에 해당하는 센서 데이터 조회하여 저장
                for (ZonedDateTime time : timeList) {
                    SensorData sensorData = sensorRepository.findBySensorIdAndSensorDataTime(sensorId, time);
                    sensorDataList.add(sensorData);
                }
                // 센서 Value를 각각 할당 realtimeSensorData의 sensorValues에 add가 5번 들어감
                for (SensorData sensorData : sensorDataList){
                    SensorValue sensorValue = new SensorValue();
                    sensorValue.setValue(sensorData.getSensorDataValue());
                    sensorValue.setTime(sensorData.getSensorDataTime());
                    realtimeSensorData.getSensorValues().add(sensorValue);
                }

            }
            // 그래프가 아닌 경우
            else{
                // TODO : 센서 value가 1개

                // 마지막 센서 데이터를 가져옴
                SensorData sensorData = sensorRepository.findLastSensorDataBySensorId(sensorId);

                // 센서 Value 를 할당
                SensorValue sensorValue = new SensorValue();
                sensorValue.setValue(sensorData.getSensorDataValue());
                sensorValue.setTime(sensorData.getSensorDataTime());
                realtimeSensorData.getSensorValues().add(sensorValue);


            }

            /** 7. 반환할 객체(sensorDataResponse)에 추가 */
            sensorDataResponse.getRealtimeSensorDataList().add(realtimeSensorData);
        }
        return sensorDataResponse;
    }

}
