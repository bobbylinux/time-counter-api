package it.estar.time_counter.controller;

import it.estar.time_counter.dto.CalendarDateDTO;
import it.estar.time_counter.services.CalendarDateService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v0/calendar_date")
@RequiredArgsConstructor
public class CalendarDateController {

    private final CalendarDateService calendarDateService;

    @GetMapping("get-all-times-in-range")
    public Page<CalendarDateDTO> getCalendar(
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam("end")   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);

        return calendarDateService.getAllTimesInRange(start, end, pageable);
    }
}
