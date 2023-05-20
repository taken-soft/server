package org.takensoft.taken_soft.dto;


import com.fasterxml.jackson.databind.util.JSONPObject;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.takensoft.taken_soft.domain.LayoutWidget;
import org.takensoft.taken_soft.dto.property.LayoutWidgetProperty;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class LayoutWidgetDto {
    private Integer id;
    private Integer layoutWidgetStartPos;
    private Integer layoutWidgetEndPos;
    private Integer layoutWidgetZPos;
    private String layoutWidgetColor;
    private String layoutWidgetProperty;

    private List<EventDto> eventDtoList;
    private List<LayoutWidgetSensorDto> layoutWidgetSensorDtoList;

    private WidgetDto widgetDTO;
    
    public LayoutWidgetDto(LayoutWidget layoutWidget,List<EventDto> eventDtoList,List<LayoutWidgetSensorDto> layoutWidgetSensorDtoList,WidgetDto widgetDto){
        LayoutWidgetDto.of(layoutWidget.getId(),layoutWidget.getLayoutWidgetStartPos(),layoutWidget.getLayoutWidgetEndPos(),
                layoutWidget.getLayoutWidgetZPos(),layoutWidget.getLayoutWidgetColor(),layoutWidget.getLayoutWidgetProperty(),eventDtoList,layoutWidgetSensorDtoList,widgetDto);
    }

}
