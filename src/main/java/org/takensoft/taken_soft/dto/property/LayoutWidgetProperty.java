package org.takensoft.taken_soft.dto.property;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.takensoft.taken_soft.dto.property.Graph;
import org.takensoft.taken_soft.dto.property.Image;
import org.takensoft.taken_soft.dto.property.Polygon;
import org.takensoft.taken_soft.dto.property.Text;

import java.io.IOException;
import java.util.Map;

/**
 * package :  org.takensoft.taken_soft.dto
 * fileName : LayoutWidgetProperty
 * author :  ShinYeaChan
 * date : 2023-05-15
 */
@Data
public class LayoutWidgetProperty {
    private Text text;
    private Graph graph;
    private Polygon polygon;
    private Image image;
}

