package org.takensoft.taken_soft.dto.request;

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
public class UpdateDashboardRequest {
    private Integer id;
    private String dashboardTitle;
    private List<LayoutDto> layoutDtoList;
}