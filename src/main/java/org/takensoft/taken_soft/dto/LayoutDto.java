package org.takensoft.taken_soft.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.takensoft.taken_soft.domain.Layout;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Data
@NoArgsConstructor
public class LayoutDto {
    private Integer layoutId;
    private Integer layoutSequence;//저장할때는 필요 없는 필드
    private List<LayoutWidgetDto> layoutWidgetDtoList = new ArrayList<>();
    
    public LayoutDto(Layout layout, List<LayoutWidgetDto> layoutWidgetDtoList) {
        this.layoutId=layout.getId();
        this.layoutSequence=layout.getLayoutSequence();
        this.layoutWidgetDtoList=layoutWidgetDtoList;
        sortLayoutWidget();
    }
    
    public static LayoutDto of(Layout layout, List<LayoutWidgetDto> layoutWidgetDtoList) {
        return new LayoutDto( layout, layoutWidgetDtoList);
    }
    private void sortLayoutWidget(){
        layoutWidgetDtoList.sort(Comparator.comparing(LayoutWidgetDto::getLayoutWidgetZPos));
    }
}


