package org.takensoft.taken_soft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.takensoft.taken_soft.domain.Dashboard;
import org.takensoft.taken_soft.dto.request.CreateDashboardRequest;
import org.takensoft.taken_soft.dto.request.UpdateDashboardRequest;
import org.takensoft.taken_soft.dto.response.CreateDashboardResponse;
import org.takensoft.taken_soft.dto.response.SingleDashboardResponse;
import org.takensoft.taken_soft.service.DashboardService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("dashboards")
@RequiredArgsConstructor
public class DashboardController {
    
    private final DashboardService dashboardService;


    /**
     * 대시보드 생성(단순 대시보드 생성) - 완료
     */
    @PostMapping("/new")
    public ResponseEntity<CreateDashboardResponse> createDashboard(@RequestBody CreateDashboardRequest createDashboardRequest) {
        CreateDashboardResponse createDashboardResponse = dashboardService.createDashboard(createDashboardRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createDashboardResponse);
    }

    /**
     * 대시보드 렌더링 요청
     *
     * @param board_id board_id
     * @return {@link ResponseEntity}
     * @see ResponseEntity
     * @see SingleDashboardResponse
     */
    @GetMapping("/{board_id}")
    public ResponseEntity<SingleDashboardResponse> getDashboards(@PathVariable Integer board_id) {
        SingleDashboardResponse singleDashboardResponse = dashboardService.getSingleDashboardDTO(board_id);
        return ResponseEntity.status(HttpStatus.OK).body(singleDashboardResponse);
    }

    /**
     * 대시보드 이름 수정
     */
    @PostMapping("/name/{board_id}")
    public ResponseEntity<Dashboard> updateDashboardName(@PathVariable Integer board_id, @RequestBody Dashboard dashboard) {
        Dashboard updatedDashboard = dashboardService.updateDashboardName(board_id, dashboard.getDashboardTitle());
        return ResponseEntity.status(HttpStatus.RESET_CONTENT).body(updatedDashboard);
    }

    /**
     * 대시보드 수정(저장)
     */
    @PostMapping("/save")
    public ResponseEntity<?> updateDashboard( @RequestBody UpdateDashboardRequest updateDashboardRequest) {
        dashboardService.updateDashboard( updateDashboardRequest);
        return ResponseEntity.status(HttpStatus.RESET_CONTENT).build();
    }

    /**
     * 대시보드 삭제
     */
    @DeleteMapping("/{board_id}")
    public ResponseEntity<Void> deleteDashboard(@PathVariable("board_id") Integer board_id) {
        dashboardService.deleteDashboard(board_id);
        return ResponseEntity.ok().build();
    }

    /** 대시보드 전체 리스트 명 조회 */
    @GetMapping("/all")
    public ResponseEntity<List<Map<String, Object>>> getAllDashboards() {
        List<Dashboard> dashboards = dashboardService.getAllDashboards();
        List<Map<String, Object>> dashboardList = new ArrayList<>();
        for (Dashboard dashboard : dashboards) {
            Map<String, Object> dashboardMap = new HashMap<>();
            dashboardMap.put("dashboardId", dashboard.getId());
            dashboardMap.put("dashboardName", dashboard.getDashboardTitle());
            dashboardList.add(dashboardMap);
        }
        return ResponseEntity.ok(dashboardList);
    }

    @DeleteMapping("/layout/{board_id}")
    public ResponseEntity<Void> deleteDashboardz(@PathVariable("board_id") Integer board_id) {
        dashboardService.deleteLayoutsByLayoutId(board_id);
        return ResponseEntity.ok().build();
    }
}