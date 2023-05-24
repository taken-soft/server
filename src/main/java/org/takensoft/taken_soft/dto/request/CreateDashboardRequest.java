package org.takensoft.taken_soft.dto.request;


import lombok.*;

/**
 *  대시보드를 새로 생성할 때 요청 객체
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateDashboardRequest {
    // 대시보드 타입
    private String dashboardType;
    // 대시보드 순서
    private Integer dashboardSequence;
}

