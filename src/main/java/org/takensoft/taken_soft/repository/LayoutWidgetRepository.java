package org.takensoft.taken_soft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.takensoft.taken_soft.domain.LayoutWidget;

@Repository
public interface LayoutWidgetRepository extends JpaRepository<LayoutWidget, Integer> {

}
