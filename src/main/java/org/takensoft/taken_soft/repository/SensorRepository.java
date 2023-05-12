package org.takensoft.taken_soft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.takensoft.taken_soft.domain.Sensor;

import java.util.Optional;
import java.util.Set;

public interface SensorRepository extends JpaRepository<Sensor, Integer> {
    Set<Sensor> findByDevice_Id(Integer id);
}