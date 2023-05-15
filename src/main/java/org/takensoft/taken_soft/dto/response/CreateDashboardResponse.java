package org.takensoft.taken_soft.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.takensoft.taken_soft.dto.LayoutDto;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateDashboardResponse {
    private Integer dashboardId;
    private List<LayoutDto> layoutDtos;
}
