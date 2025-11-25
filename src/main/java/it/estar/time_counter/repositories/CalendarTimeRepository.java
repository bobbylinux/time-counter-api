package it.estar.time_counter.repositories;

import it.estar.time_counter.domain.CalendarTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarTimeRepository extends JpaRepository<CalendarTime, Long> {}

