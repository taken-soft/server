package org.takensoft.taken_soft.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "widget")
@Getter
@Setter
public class Widget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "widget_id", nullable = false)
    private Integer id;
    
    @Column(name = "widget_type", length = 40)
    private String widgetType;
    
    @OneToMany(mappedBy = "widget")
    private Set<LayoutWidget> layoutWidgets = new LinkedHashSet<>();
    
}