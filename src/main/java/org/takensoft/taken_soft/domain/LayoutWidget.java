package org.takensoft.taken_soft.domain;

//import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import jakarta.persistence.*;
import lombok.*;
import org.takensoft.taken_soft.dto.LayoutWidgetDto;

import java.io.Serializable;
import java.util.Set;
//import org.hibernate.annotations.TypeDef;
@Entity
@Table(name = "layout_widget")
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LayoutWidget implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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


    @Column(name = "layout_widget_property")
    private String layoutWidgetProperty;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "widget_id", nullable = false)
    @ToString.Exclude
    private Widget widget;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "layout_id",nullable = false)
    @ToString.Exclude
    private Layout layout;

    @OneToMany(mappedBy = "layoutWidget", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Set<LayoutWidgetSensor> layoutWidgetSensors;

    @OneToMany(mappedBy = "layoutWidget", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Set<Event> events;
    
    public void setLayout(Layout layout) {
        this.layout = layout;
    }
    
    public void setWidget(Widget widget) {
        this.widget = widget;
    }
    
    public LayoutWidget(LayoutWidgetDto layoutWidgetDto, Widget widget,
                        Layout layout) {
        this.layoutWidgetStartPos = layoutWidgetDto.getLayoutWidgetStartPos();
        this.layoutWidgetEndPos = layoutWidgetDto.getLayoutWidgetEndPos();
        this.layoutWidgetZPos = layoutWidgetDto.getLayoutWidgetZPos();
        this.layoutWidgetColor = layoutWidgetDto.getLayoutWidgetColor();
        this.layoutWidgetProperty = layoutWidgetDto.getLayoutWidgetProperty();
        this.widget = widget;
        this.layout = layout;
    }
    
    public static LayoutWidget ofDto(LayoutWidgetDto layoutWidgetDto,Widget widget,
                                     Layout layout) {
        return new LayoutWidget(layoutWidgetDto,widget,layout);
    }
    
    public void setLayoutWidgetSensors(Set<LayoutWidgetSensor> layoutWidgetSensors) {
        this.layoutWidgetSensors = layoutWidgetSensors;
    }
    
    public void setEvents(Set<Event> events) {
        this.events = events;
    }
}