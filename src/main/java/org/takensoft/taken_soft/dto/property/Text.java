package org.takensoft.taken_soft.dto.property;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Text {
    private String textColor;
    private String operation;
    private String innerText;

}
