package org.takensoft.taken_soft.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateDashboardRequest {
    private Integer id;
    private String dashboardTitle;
    private List<LayoutDTO> layoutDTOList;
}
