package org.takensoft.taken_soft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.transaction.annotation.Transactional;
import org.takensoft.taken_soft.domain.Sensor;
import org.takensoft.taken_soft.domain.SensorData;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Transactional
public interface SensorDataRepository extends JpaRepository<SensorData, Integer> {
}