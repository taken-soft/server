package org.takensoft.taken_soft.dto.property;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Graph {
    private Map<String,String> colors =new HashMap<>();
}
