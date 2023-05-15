package org.takensoft.taken_soft.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.takensoft.taken_soft.domain.Dashboard;
import org.takensoft.taken_soft.dto.CreateDashboardResponse;

/** 사실상 모든 기능이 여기서 일어난다해도 과언이 아니다...*/
@Repository
public interface DashBoardRepository extends JpaRepository<Dashboard, Integer> {
    Dashboard save(Dashboard dashboard);
}