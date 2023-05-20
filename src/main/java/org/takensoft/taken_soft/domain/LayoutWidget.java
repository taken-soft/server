package org.takensoft.taken_soft.domain;

//import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.basic.PostgreSQLHStoreType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;
import org.takensoft.taken_soft.dto.property.LayoutWidgetProperty;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;
//import org.hibernate.annotations.TypeDef;
@Entity
@Table(name = "layout_widget")
@Getter
@Builder
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
    private Widget widget;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "layout_id",nullable = false)
    private Layout layout;

    @OneToMany(mappedBy = "layoutWidget", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<LayoutWidgetSensor> layoutWidgetSensors = new LinkedHashSet<>();

    @OneToMany(mappedBy = "layoutWidget", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Event> events = new LinkedHashSet<>();

}