package org.takensoft.taken_soft.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateDashboardRequest {
    // 대시보드 타입
    private String dashboardType;
    // 대시보드 순서
    private Integer dashboardSequence;
}

