package org.takensoft.taken_soft.dto;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventDto {
    @Nullable
    private Integer id;
    private Integer eventOver;
    private Integer eventUnder;
    private String eventColor;
    private String eventType;
}




