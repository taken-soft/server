package org.takensoft.taken_soft.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.takensoft.taken_soft.domain.Event;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class EventDto {
    private Integer eventId;
    private Integer eventOver;
    private Integer eventUnder;
    private String eventColor;
    private String eventType;
    public EventDto(Event event){
        EventDto.of(event.getId(),event.getEventOver(),event.getEventUnder(),event.getEventColor(),event.getEventType());
    }
}




