package com.bliblifuture.repository;

import com.bliblifuture.model.StockOpname;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StockOpnameRepository extends JpaRepository<StockOpname, String> {
    StockOpname findByStockOpnameId(String stockOpnameId);
//    List<StockOpname> findByFinishCountingTime(LocalDateTime finishCountingTime);
    List<StockOpname> findByStartCountingTime(LocalDateTime startCountingTime);
    List<StockOpname> findByStartCountingTimeBetween(LocalDateTime start, LocalDateTime end);
    List<StockOpname> findByReportDate(LocalDate date);

}
