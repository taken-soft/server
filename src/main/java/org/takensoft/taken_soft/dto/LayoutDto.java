package org.takensoft.taken_soft.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.takensoft.taken_soft.domain.Layout;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class LayoutDto {
    private Integer id;
    private Integer layoutSequence;
    private List<LayoutWidgetDto> layoutWidgetDtoList = new ArrayList<>();
    public LayoutDto(Layout layout,List<LayoutWidgetDto> layoutWidgetDtoList){
        LayoutDto.of(layout.getId(),layout.getLayoutSequence(),layoutWidgetDtoList);
    }
}


