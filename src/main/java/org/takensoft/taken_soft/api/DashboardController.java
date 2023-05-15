package org.takensoft.taken_soft.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.takensoft.taken_soft.dto.CreateDashboardRequest;
import org.takensoft.taken_soft.dto.CreateDashboardResponse;
import org.takensoft.taken_soft.dto.UpdateDashboardRequest;
import org.takensoft.taken_soft.dto.ResponseSingleDashboardDto;
import org.takensoft.taken_soft.service.DashboardService;
import org.takensoft.taken_soft.domain.Dashboard;

import java.util.List;


@Controller
@RequestMapping("dashboards")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;


    /** 대시보드 생성(단순 대시보드 생성) - 완료 */
    @PostMapping("/new")
    public ResponseEntity<CreateDashboardResponse> createDashboard(@RequestBody CreateDashboardRequest createDashboardRequest) {
        CreateDashboardResponse createDashboardResponse = dashboardService.createDashboard(createDashboardRequest);
        return ResponseEntity.ok(createDashboardResponse);
    }

    /** 대시보드 조회 */
    @GetMapping("/{board_id}")
    public ResponseEntity<ResponseSingleDashboardDto> getDashboards(@PathVariable Integer board_id) {
        ResponseSingleDashboardDto responseSingleDashboardDTO = dashboardService.getSingleDashboardDTO(board_id);
        return ResponseEntity.ok(responseSingleDashboardDTO);
    }

    /** 대시보드 이름 수정 */
    @PostMapping("/name/{board_id}")
    public ResponseEntity<Dashboard> updateDashboardName(@PathVariable Integer board_id, @RequestBody Dashboard dashboard) {
        Dashboard updatedDashboard = dashboardService.updateDashboardName(board_id, dashboard.getDashboardTitle());
        return ResponseEntity.ok(updatedDashboard);
    }

    /** 대시보드 수정(저장) - 완료 */
    @PostMapping("/{board_id}")
    public ResponseEntity<Dashboard> updateDashboard(@PathVariable Integer board_id, @RequestBody UpdateDashboardRequest updateDashboardRequest) {
        Dashboard updatedDashboard = dashboardService.updateDashboard(board_id, updateDashboardRequest);
        return ResponseEntity.ok(updatedDashboard);
    }

    /** 대시보드 삭제 */
    @DeleteMapping("/{board_id}")
    public ResponseEntity<Void> deleteDashboard(@PathVariable("board_id") Integer board_id) {
        dashboardService.deleteDashboard(board_id);
        return ResponseEntity.ok().build();
    }

    /** 대시보드 전체 리스트 명 조회 */
    @GetMapping("/all")
    public ResponseEntity<List<Dashboard>> getAllDashboards() {
        List<Dashboard> dashboards = dashboardService.getAllDashboards();
        return ResponseEntity.ok(dashboards);
    }
}
