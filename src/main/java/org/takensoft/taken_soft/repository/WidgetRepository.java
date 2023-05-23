package org.takensoft.taken_soft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.takensoft.taken_soft.domain.Widget;

public interface WidgetRepository extends JpaRepository<Widget, Integer> {
}