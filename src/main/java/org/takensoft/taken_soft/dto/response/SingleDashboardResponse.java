package org.takensoft.taken_soft.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.takensoft.taken_soft.domain.Layout;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/** 사용자에게 대시보드 1개의 모든 정보를 담아 리턴해주는 DTO */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SingleDashboardResponse {
    private Integer id;
    private String dashboardTitle;
    private String dashboardType;
    private Integer dashboardSequence;
    private List<Layout> layoutList=new ArrayList<>();
    /** 수정 필요 - 매우 중요 */
}
