package org.takensoft.taken_soft.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.takensoft.taken_soft.domain.Widget;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class WidgetDto {
    private Integer widgetId;
    private String widgetType;
    public WidgetDto(Widget widget){
        WidgetDto.of(widget.getId(),widget.getWidgetType());
    }
}
