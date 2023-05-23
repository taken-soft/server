package org.takensoft.taken_soft.dto.property;

import lombok.*;
import org.takensoft.taken_soft.dto.property.Graph;
import org.takensoft.taken_soft.dto.property.Image;
import org.takensoft.taken_soft.dto.property.Polygon;
import org.takensoft.taken_soft.dto.property.Text;

/**
 * package :  org.takensoft.taken_soft.dto
 * fileName : LayoutWidgetProperty
 * author :  ShinYeaChan
 * date : 2023-05-15
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LayoutWidgetProperty {
    private Text text;
    private Graph graph;
    private Polygon polygon;
    private Image image;
}

