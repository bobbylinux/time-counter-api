package it.estar.time_counter.repositories;

import it.estar.time_counter.domain.CalendarTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarTimeRepository extends JpaRepository<CalendarTime, Long> {}

