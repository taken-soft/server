package org.takensoft.taken_soft.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LayoutDto {
    private Integer id;
    private Integer layoutSequence;
    private List<LayoutWidgetDto> layoutWidgetDtoList = new ArrayList<>();
}


