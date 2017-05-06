package com.bliblifuture.repository;

import com.bliblifuture.model.Counter;
import com.bliblifuture.model.StockOpname;
import org.joda.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockOpnameRepository extends JpaRepository<StockOpname, String> {
    StockOpname findByStockOpnameId(String stockOpnameId);
    List<StockOpname> findByReportDate(LocalDate date);
    List<StockOpname> findByAssignedTo(Counter counter);

}
