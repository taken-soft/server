package org.takensoft.taken_soft.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "dashboard")
@Getter
@Setter
@Builder // Builder를 통해서 유연하게 객체를 생성가능.
@NoArgsConstructor // 파라미터가 없는 기본 생성자를 생성
@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 생성자를 만듦
public class Dashboard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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