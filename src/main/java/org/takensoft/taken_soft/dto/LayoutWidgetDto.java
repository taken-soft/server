package org.takensoft.taken_soft.dto;


import com.fasterxml.jackson.databind.util.JSONPObject;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LayoutWidgetDto {
    @Nullable
    private Integer id;
    private Integer layoutWidgetStartPos;
    private Integer layoutWidgetEndPos;
    private Integer layoutWidgetZPos;
    private String layoutWidgetColor;
    private JSONPObject layoutWidgetProperty;

    private List<EventDto> eventDtoList;
    private List<LayoutWidgetSensorDto> layoutWidgetSensorDtoList;

    private WidgetDto widgetDTO;

}
