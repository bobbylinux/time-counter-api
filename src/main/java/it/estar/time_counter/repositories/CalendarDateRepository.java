package it.estar.time_counter.repositories;

import it.estar.time_counter.domain.CalendarDate;
import it.estar.time_counter.dto.CalendarDateDTO;
import it.estar.time_counter.dto.CalendarDateFlatDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface CalendarDateRepository extends JpaRepository<CalendarDate, Long> {
    @Query(value = """
            select cd.calendar_date, ct.calendar_time, ct.mark_type
            from calendars_dates cd inner join calendars_times ct
            on cd.id = ct.calendar_date
            where cd.calendar_date between :start and :end
            order by cd.calendar_date, ct.calendar_time
            """, countQuery = """
                SELECT COUNT(1) as count 
                FROM calendars_dates cd
                INNER JOIN calendars_times ct 
                    ON cd.id = ct.calendar_date
                WHERE cd.calendar_date BETWEEN :start AND :end
            """, nativeQuery = true)
    Page<CalendarDateFlatDTO> getAllTimesInRange(@Param("start") LocalDate start, @Param("end") LocalDate end, Pageable pageable);


}

