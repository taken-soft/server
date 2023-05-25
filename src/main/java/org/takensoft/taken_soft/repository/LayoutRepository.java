package org.takensoft.taken_soft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.takensoft.taken_soft.domain.Dashboard;
import org.takensoft.taken_soft.domain.Layout;

@Transactional
public interface LayoutRepository extends JpaRepository<Layout, Integer> {
    void deleteAllByDashboard(Dashboard dashboard);
}
