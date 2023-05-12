package org.takensoft.taken_soft.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "layout_widget")
@Getter
@Setter
public class LayoutWidget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "layout_widget_id", nullable = false)
    private Integer id;
    
    @Column(name = "layout_widget_start_pos")
    private Integer layoutWidgetStartPos;
    
    @Column(name = "layout_widget_end_pos")
    private Integer layoutWidgetEndPos;
    
    @Column(name = "layout_widget_z_pos")
    private Integer layoutWidgetZPos;
    
    @Column(name = "layout_widget_color", length = 40)
    private String layoutWidgetColor;
    
    @Column(name = "layout_widget_property", length = Integer.MAX_VALUE)
    private String layoutWidgetProperty;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "widget_id", nullable = false)
    private Widget widget;
    
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "layout_id",nullable = false)
    private Layout layout;
    
    @OneToMany(mappedBy = "layoutWidget")
    private Set<LayoutWidgetSensor> layoutWidgetSensors = new LinkedHashSet<>();
    
    @OneToMany(mappedBy = "layoutWidget")
    private Set<Event> events=new LinkedHashSet<>();
}