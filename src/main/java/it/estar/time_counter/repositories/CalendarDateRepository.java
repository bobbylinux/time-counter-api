package it.estar.time_counter.repositories;

import it.estar.time_counter.domain.CalendarDate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarDateRepository extends JpaRepository<CalendarDate, Long> {}

