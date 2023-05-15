package org.takensoft.taken_soft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.takensoft.taken_soft.domain.Device;
import org.takensoft.taken_soft.domain.Layout;

public interface LayoutRepository extends JpaRepository<Layout, Integer> {

}
