package it.estar.time_counter.services;

import it.estar.time_counter.dto.CalendarDateDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public interface CalendarDateService {
    Optional<CalendarDateDTO> getTimesByCalendarDate(LocalDate date);
    Page<CalendarDateDTO> getAllTimesInRange(LocalDate start, LocalDate end, Pageable pageable);

}
