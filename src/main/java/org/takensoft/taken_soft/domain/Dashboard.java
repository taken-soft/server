package org.takensoft.taken_soft.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "dashboard")
@Getter
@Setter
public class Dashboard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dashboard_id", nullable = false)
    private Integer id;
    
    @Column(name = "dashboard_title", length = 40)
    private String dashboardTitle;
    
    @Column(name = "dashboard_type", length = 10)
    private String dashboardType;
    
    @Column(name = "dashboard_sequence")
    private Integer dashboardSequence;
    
    @OneToMany(mappedBy = "dashboard")
    private Set<Layout> layouts = new LinkedHashSet<>();
}