package org.takensoft.taken_soft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.takensoft.taken_soft.domain.LayoutWidgetSensor;


@Repository
public interface LayoutWidgetSensorRepository extends JpaRepository<LayoutWidgetSensor, Integer> {


}
