package org.takensoft.taken_soft.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.takensoft.taken_soft.domain.Layout;
import org.takensoft.taken_soft.dto.LayoutDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;



/**
 *  대시보드 렌더링 응답 객체
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SingleDashboardResponse {
    private Integer id;
    private String dashboardTitle;
    private String dashboardType;
    private Integer dashboardSequence;
    private List<LayoutDto> layoutList=new ArrayList<>();
    /** 수정 필요 - 매우 중요 */
    public static SingleDashboardResponse create(Integer id,String dashboardTitle,String dashboardType,Integer dashboardSequence,List<LayoutDto> layoutList){
       return new SingleDashboardResponse(id,dashboardTitle,dashboardType,dashboardSequence,layoutList);
    }
}
