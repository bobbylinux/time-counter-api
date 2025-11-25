package it.estar.time_counter.dto;

import it.estar.time_counter.domain.MarkType;

import java.time.LocalDate;
import java.time.LocalTime;

public interface CalendarDateFlatDTO {
    LocalDate getCalendarDate();
    LocalTime getCalendarTime();
    MarkType getMarkType();
}
