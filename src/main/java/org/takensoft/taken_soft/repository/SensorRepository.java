package org.takensoft.taken_soft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.takensoft.taken_soft.domain.Sensor;
import org.takensoft.taken_soft.domain.SensorData;

import java.time.ZonedDateTime;
import java.util.Set;

@Transactional
@Repository
public interface SensorRepository extends JpaRepository<Sensor, Integer> {
    Set<Sensor> findByDevice_Id(Integer id);

    @Query("SELECT sensorData FROM SensorData sensorData JOIN FETCH sensorData.sensor sensor WHERE sensor.id = :sensorId AND sensorData.sensorDataTime = (SELECT MAX(sensorData2.sensorDataTime) FROM SensorData sensorData2 WHERE sensorData2.sensor = sensor)")
    SensorData findLastSensorDataBySensorId(@Param("sensorId") Integer sensorId);

    @Query("SELECT sensorData FROM SensorData sensorData JOIN FETCH sensorData.sensor sensor WHERE sensor.id = :sensorId AND sensorData.sensorDataTime = :time")
    SensorData findBySensorIdAndSensorDataTime(@Param("sensorId") Integer sensorId, @Param("time") ZonedDateTime time);

}