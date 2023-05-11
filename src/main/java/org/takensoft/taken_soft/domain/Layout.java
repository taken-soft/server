package org.takensoft.taken_soft.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "layout")
@Getter
@Setter
public class Layout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "layout_id", nullable = false)
    private Integer id;
    
    @Column(name = "layout_sequence")
    private Integer layoutSequence;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "dashboard_id", nullable = false)
    private Dashboard dashboard;
    
    @OneToMany(mappedBy = "layout")
    private Set<LayoutWidget>layoutWidgets=new LinkedHashSet<>();
    
    
}