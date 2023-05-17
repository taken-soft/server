package org.takensoft.taken_soft.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.takensoft.taken_soft.domain.Layout;
import org.takensoft.taken_soft.domain.LayoutWidget;
import org.takensoft.taken_soft.domain.Widget;
import org.takensoft.taken_soft.dto.property.*;

import java.util.HashMap;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * package :  org.takensoft.taken_soft.repository
 * fileName : LayoutWidgetRepositoryTest
 * author :  ShinYeaChan
 * date : 2023-05-17
 */
@DataJpaTest
@Slf4j
class LayoutWidgetRepositoryTest {
    @Autowired
    private LayoutWidgetRepository layoutWidgetRepository;
    private LayoutWidget layoutWidget;
    
    @Test
    void 엔티티_테스트() {
        
        layoutWidget=LayoutWidget
                .builder()
                .layoutWidgetProperty(LayoutWidgetProperty
                        .builder()
                        .graph(Graph.builder()
                                .colors(new HashMap<>())
                                .build())
                        .image(Image.builder()
                                .src("src")
                                .build())
                        .polygon(Polygon.builder()
                                .operation("operation")
                                .build())
                        .text(Text.builder()
                                .innerText("innerText")
                                .operation("operation")
                                .textColor("textColor")
                                .build())
                        .build())
                .build();
        System.out.println("레이아웃 위젯 속성 : "+layoutWidget.getLayoutWidgetProperty().toString());
        
//        assertThat(layoutWidgetRepository.save(layoutWidget)).isEqualTo(layoutWidget);
    }
}