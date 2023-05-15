package org.takensoft.taken_soft.dto;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.takensoft.taken_soft.domain.Dashboard;
import org.takensoft.taken_soft.domain.LayoutWidget;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LayoutDTO {
    private Integer id;
    private Integer layoutSequence;
    private List<LayoutWidgetDTO> layoutWidgetDTOList = new ArrayList<>();
}


