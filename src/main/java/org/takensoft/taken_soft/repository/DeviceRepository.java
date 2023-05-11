package org.takensoft.taken_soft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.takensoft.taken_soft.domain.Device;

public interface DeviceRepository extends JpaRepository<Device, Integer> {
}