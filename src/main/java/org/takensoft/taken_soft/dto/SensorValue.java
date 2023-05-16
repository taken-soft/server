package org.takensoft.taken_soft.dto;

import lombok.Data;

import java.time.ZonedDateTime;

/**
 * package :  org.takensoft.taken_soft.dto
 * fileName : SensorValue
 * author :  ShinYeaChan
 * date : 2023-05-15
 */
@Data
public class SensorValue {
    private ZonedDateTime time;
    private String value;
}
