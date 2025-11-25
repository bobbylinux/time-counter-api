package it.estar.time_counter.repositories;

import it.estar.time_counter.domain.CalendarDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarDateRepository extends JpaRepository<CalendarDate, Long> {}

