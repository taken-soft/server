package org.takensoft.taken_soft.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.takensoft.taken_soft.dto.request.SensorDataRequest;
import org.takensoft.taken_soft.dto.response.SensorDataResponse;
import org.takensoft.taken_soft.service.SensorService;

@Controller
@RequestMapping("sensor")
public class SensorController {

    @Autowired
    private SensorService sensorservice;

    /** 센서 데이터 요청 */
    @PostMapping("/data")
    public ResponseEntity<SensorDataResponse> createDashboard(@RequestBody SensorDataRequest sensorDataRequest ) {
        SensorDataResponse sensorDataResponse = sensorservice.getSensorData(sensorDataRequest);
        return ResponseEntity.ok(sensorDataResponse);
    }

}
