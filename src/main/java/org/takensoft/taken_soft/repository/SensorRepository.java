package org.takensoft.taken_soft.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.takensoft.taken_soft.domain.Sensor;
import org.takensoft.taken_soft.domain.SensorData;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface SensorRepository extends JpaRepository<Sensor, Integer> {
    Set<Sensor> findByDevice_Id(Integer id);

    @Query("SELECT sensorData FROM SensorData sensorData JOIN FETCH sensorData.sensor sensor WHERE sensor.id = :sensorId AND sensorData.sensorDataTime = (SELECT MAX(sensorData2.sensorDataTime) FROM SensorData sensorData2 WHERE sensorData2.sensor = sensor)")
    SensorData findLastSensorDataBySensorId(Integer sensorId);

}