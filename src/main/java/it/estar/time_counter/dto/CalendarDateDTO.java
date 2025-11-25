package it.estar.time_counter.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class CalendarDateDTO {
    private LocalDate calendar_date;
    private List<CalendarTimeDTO> times;
}
