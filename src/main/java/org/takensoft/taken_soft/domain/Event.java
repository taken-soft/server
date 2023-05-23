package org.takensoft.taken_soft.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.takensoft.taken_soft.dto.EventDto;

@Entity
@Table(name = "event")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "event_id", nullable = false)
    private Integer id;
    
    @Column(name = "event_over")
    private Integer eventOver;
    
    @Column(name = "event_under")
    private Integer eventUnder;
    
    @Column(name = "event_color", length = 40)
    private String eventColor;
    
    @Column(name = "event_type", length = 40)
    private String eventType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "layout_widget_id", nullable = false)
    @ToString.Exclude
    private LayoutWidget layoutWidget;
    
    private Event(EventDto eventDto,LayoutWidget layoutWidget){
        this.eventType=eventDto.getEventType();
        this.eventColor=eventDto.getEventColor();
        this.eventOver=eventDto.getEventOver();
        this.eventUnder=eventDto.getEventUnder();
        this.layoutWidget=layoutWidget;
    }
    
    public static Event ofDto(EventDto eventDto,LayoutWidget layoutWidget) {
        return new Event(eventDto,layoutWidget);
    }
}