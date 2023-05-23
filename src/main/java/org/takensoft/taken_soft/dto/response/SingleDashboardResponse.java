package org.takensoft.taken_soft.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.takensoft.taken_soft.domain.Dashboard;
import org.takensoft.taken_soft.dto.LayoutDto;

import java.util.ArrayList;
import java.util.List;



/**
 *  대시보드 렌더링 응답 객체
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SingleDashboardResponse {
    private Integer dashboardId;
    private String dashboardTitle;
    private String dashboardType;
    private Integer dashboardSequence;
    private List<LayoutDto> layoutList=new ArrayList<>();
    
    public SingleDashboardResponse(Dashboard dashboard, List<LayoutDto> layoutDtoList) {
        this.dashboardId=dashboard.getId();
        this.dashboardTitle=dashboard.getDashboardTitle();
        this.dashboardType=dashboard.getDashboardType();
        this.dashboardSequence=dashboard.getDashboardSequence();
        this.layoutList=layoutDtoList;
    }
    
    public static SingleDashboardResponse of(Dashboard dashboard, List<LayoutDto> layoutDtoList) {
        return new SingleDashboardResponse(dashboard,layoutDtoList);
    }
}
