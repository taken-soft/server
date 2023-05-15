package org.takensoft.taken_soft.dto;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.takensoft.taken_soft.domain.LayoutWidget;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventDTO {
    @Nullable
    private Integer id;
    private Integer eventOver;
    private Integer eventUnder;
    private String eventColor;
    private String eventType;
}




