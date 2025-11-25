package it.estar.time_counter.dto;

import it.estar.time_counter.domain.MarkType;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class CalendarTimeDTO {
    private LocalTime time;
    private MarkType markType;
}
