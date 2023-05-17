package org.takensoft.taken_soft;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.takensoft.taken_soft.domain.Device;
import org.takensoft.taken_soft.domain.Sensor;
import org.takensoft.taken_soft.domain.SensorData;
import org.takensoft.taken_soft.repository.DeviceRepository;
import org.takensoft.taken_soft.repository.SensorDataRepository;
import org.takensoft.taken_soft.repository.SensorRepository;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Component
@Slf4j
public class DataModule {

    @Autowired
    private DeviceRepository deviceRepository;
    
    @Autowired
    private SensorDataRepository sensorDataRepository;
    
    @Autowired
    private SensorRepository sensorRepository;

    @Scheduled(fixedDelay = 1000)
    @Transactional
    public void addData() {
        List<Device> devices = deviceRepository.findAll();
        for (Device device : devices) {
            log.info("Device name: {}", Objects.requireNonNull(device).getDeviceName());
            setAllSensorData(device);
        }
    }
    
    private void setAllSensorData(Device device) {
        Set<Sensor> sensors = sensorRepository.findByDevice_Id(device.getId());
        for (Sensor sensor : sensors) {
            log.info("센서 이름: {}", sensor.getSensorName());
            log.info("센서 id: {}", sensor.getId());
            saveSensorData(sensor);
        }
    }
    
    private void saveSensorData(Sensor sensor) {
        SensorData sensorData = new SensorData();
        sensorData.setSensor(sensor);
        sensorData.setSensorDataValue(String.valueOf(Math.random() * 100 + 1));
        ZonedDateTime now = ZonedDateTime.now().withNano(0);
        sensorData.setSensorDataTime(now);
        sensorDataRepository.save(sensorData);
    }
}