package org.takensoft.taken_soft.dto;


import com.fasterxml.jackson.databind.util.JSONPObject;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.takensoft.taken_soft.domain.Event;
import org.takensoft.taken_soft.domain.Layout;
import org.takensoft.taken_soft.domain.LayoutWidgetSensor;
import org.takensoft.taken_soft.domain.Widget;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LayoutWidgetDTO {
    @Nullable
    private Integer id;
    private Integer layoutWidgetStartPos;
    private Integer layoutWidgetEndPos;
    private Integer layoutWidgetZPos;
    private String layoutWidgetColor;
    private JSONPObject layoutWidgetProperty;

    private List<EventDTO> eventDTOList;
    private List<LayoutWidgetSensorDTO> layoutWidgetSensorDTOList;

    private WidgetDTO widgetDTO;

}
