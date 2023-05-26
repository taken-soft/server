package org.takensoft.taken_soft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.takensoft.taken_soft.domain.Sensor;
import org.takensoft.taken_soft.domain.SensorData;

import java.time.ZonedDateTime;

@Transactional
public interface SensorDataRepository extends JpaRepository<SensorData, Integer> {
  boolean existsBySensorDataTimeAndSensor(ZonedDateTime now, Sensor sensor);
}



