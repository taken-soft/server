package org.takensoft.taken_soft.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.takensoft.taken_soft.domain.LayoutWidget;

import java.util.List;

@Data
@NoArgsConstructor
@Slf4j
public class LayoutWidgetDto {
    private Integer layoutWidgetId;//
    private Integer layoutWidgetStartPos;
    private Integer layoutWidgetEndPos;
    private Integer layoutWidgetZPos;
    private String layoutWidgetColor;
    private String layoutWidgetProperty;
    
    private List<EventDto> eventDtoList;
    private List<LayoutWidgetSensorDto> layoutWidgetSensorDtoList;
    
    private Integer widgetId;
    
    
    public static LayoutWidgetDto of(LayoutWidget layoutWidget, List<EventDto> eventDtoList, List<LayoutWidgetSensorDto> layoutWidgetSensorDtoList) {
        log.info("LayoutWidgetDto 생성자");
        return new LayoutWidgetDto(layoutWidget, eventDtoList, layoutWidgetSensorDtoList);
    }
    
    public LayoutWidgetDto(LayoutWidget layoutWidget, List<EventDto> eventDtoList, List<LayoutWidgetSensorDto> layoutWidgetSensorDtoList) {
        this.layoutWidgetId=layoutWidget.getId();
        this.layoutWidgetStartPos = layoutWidget.getLayoutWidgetStartPos();
        this.layoutWidgetEndPos = layoutWidget.getLayoutWidgetEndPos();
        this.layoutWidgetZPos = layoutWidget.getLayoutWidgetZPos();
        this.layoutWidgetColor = layoutWidget.getLayoutWidgetColor();
        this.layoutWidgetProperty = layoutWidget.getLayoutWidgetProperty();
        this.eventDtoList = eventDtoList;
        this.layoutWidgetSensorDtoList = layoutWidgetSensorDtoList;
        this.widgetId = layoutWidget.getWidget().getId();
    }
}
