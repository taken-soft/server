package org.takensoft.taken_soft.dto.response;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.takensoft.taken_soft.dto.LayoutDto;

import java.util.Comparator;
import java.util.List;
/**
 *  새로 생성한 대시보드의 2*2 or 2*4 레이아웃
 *
 */
@Data
@Builder
@NoArgsConstructor
public class CreateDashboardResponse {
    private Integer dashboardId;
    private List<LayoutDto> layoutDtoList;
    
    public CreateDashboardResponse(Integer dashboardId, List<LayoutDto> layoutDtoList) {
        this.dashboardId = dashboardId;
        this.layoutDtoList = layoutDtoList;
        sortLayoutDtoList();
    }
    
    public void sortLayoutDtoList() {
        layoutDtoList.sort(Comparator.comparing(LayoutDto::getLayoutSequence).reversed());
    }
}
