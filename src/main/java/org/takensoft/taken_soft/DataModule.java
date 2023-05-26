package org.takensoft.taken_soft;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
import java.util.Random;
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

    @Scheduled(fixedRate = 1000)
    @Transactional
    public void addData() {
        try{
            List<Device> devices = deviceRepository.findAll();
            for (Device device : devices) {
//            log.info("Device name: {}", Objects.requireNonNull(device).getDeviceName());
                setAllSensorData(device);
            }
        }
        catch (DataAccessException ex) {
            log.error("Error saving sensor data: {}", ex.getMessage());
        }
    }
    
    private void setAllSensorData(Device device) {
        Set<Sensor> sensors = sensorRepository.findByDevice_Id(device.getId());
        for (Sensor sensor : sensors) {
//            log.info("센서 이름: {}", sensor.getSensorName());
//            log.info("센서 id: {}", sensor.getId());
            saveSensorData(sensor);
        }
    }

    private void saveSensorData(Sensor sensor) {
        SensorData sensorData = new SensorData();
        sensorData.setSensor(sensor);
        sensorData.setSensorDataValue(getRandomSensorValue(sensor.getSensorUnit()));
        ZonedDateTime now = ZonedDateTime.now().withNano(0);
        sensorData.setSensorDataTime(now);
        if(!sensorDataRepository.existsBySensorDataTime(now))
            sensorDataRepository.save(sensorData);
    }
    
    private String getRandomSensorValue(String sensorUnit) {
        switch (sensorUnit) {
            case "rpm" -> {
                return String.format("%.3f", Math.random() * 2000 + 5000);
            }
            case "%" -> {
                return String.format("%.3f", Math.random() * 40 + 30);
            }
            case "ºC" -> {
                return String.format("%.3f", Math.random() * 190 + 10);
            }
            case "mm" -> {
                return String.format("%.3f", Math.random() * 70 + 30);
            }
            case "MPa", "Mpa" -> {
                return String.format("%.3f", Math.random() * 20 + 1);
            }
            case "l/min" -> {
                return String.format("%.3f", Math.random() * 9.5 + 0.5);
            }
            case "HZ" -> {
                return String.format("%.3f", Math.random() * 100 + 1);
            }
            case "on/off" -> {
                Random random = new Random();
                return random.nextBoolean() ? "on" : "off";
            }
            default -> {
                return null;
            }
        }
    }
}