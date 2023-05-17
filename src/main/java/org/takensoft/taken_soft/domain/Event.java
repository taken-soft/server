package org.takensoft.taken_soft.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "event")
@Getter
@Setter
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
    private LayoutWidget layoutWidget;
    
}