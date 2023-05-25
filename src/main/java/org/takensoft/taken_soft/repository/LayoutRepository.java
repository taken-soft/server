package org.takensoft.taken_soft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.takensoft.taken_soft.domain.Dashboard;
import org.takensoft.taken_soft.domain.Layout;

@Repository
public interface LayoutRepository extends JpaRepository<Layout, Integer> {
    void deleteByDashboard(Dashboard dashboard);
    

}

