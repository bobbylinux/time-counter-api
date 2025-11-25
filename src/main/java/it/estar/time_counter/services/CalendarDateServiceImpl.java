package it.estar.time_counter.services;


import it.estar.time_counter.dto.CalendarDateDTO;
import it.estar.time_counter.dto.CalendarDateFlatDTO;
import it.estar.time_counter.dto.CalendarTimeDTO;
import it.estar.time_counter.repositories.CalendarDateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class CalendarDateServiceImpl implements  CalendarDateService {

    @Autowired
    private CalendarDateRepository calendarDateRepository;

    @Override
    public Optional<CalendarDateDTO> getTimesByCalendarDate(LocalDate date) {
        return Optional.empty();
    }

    @Override
    public Page<CalendarDateDTO> getAllTimesInRange(LocalDate start, LocalDate end, Pageable pageable) {
        Page<CalendarDateFlatDTO> page = calendarDateRepository.getAllTimesInRange(start, end, pageable);

        // gruppi SOLO gli elementi della pagina corrente
        Map<LocalDate, CalendarDateDTO> grouped = new LinkedHashMap<>();

        for (CalendarDateFlatDTO r : page.getContent()) {

            CalendarDateDTO dateDto = grouped
                    .computeIfAbsent(r.getCalendarDate(), d -> {
                        CalendarDateDTO dto = new CalendarDateDTO();
                        dto.setCalendar_date(d);
                        dto.setTimes(new ArrayList<>());
                        return dto;
                    });

            CalendarTimeDTO timeDto = new CalendarTimeDTO();
            timeDto.setTime(r.getCalendarTime());
            timeDto.setMarkType(r.getMarkType());

            dateDto.getTimes().add(timeDto);
        }

        List<CalendarDateDTO> results = new ArrayList<>(grouped.values());

        return new PageImpl<>(
                results,
                pageable,
                page.getTotalElements()
        );
    }
}
