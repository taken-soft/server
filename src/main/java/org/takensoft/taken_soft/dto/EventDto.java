package org.takensoft.taken_soft.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.takensoft.taken_soft.domain.Event;

@Data
@NoArgsConstructor
public class EventDto {
    private Integer eventId;//
    private Integer eventOver;
    private Integer eventUnder;
    private String eventColor;
    private String eventType;//bgcolor, boarder
    
    public static EventDto of(Event event) {
        return new EventDto(event);
    }
    
    public EventDto(Event event) {
        this.eventId = event.getId();
        this.eventOver = event.getEventOver();
        this.eventUnder = event.getEventUnder();
        this.eventColor = event.getEventColor();
        this.eventType = event.getEventType();
    }
}




