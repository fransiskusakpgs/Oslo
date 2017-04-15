package com.bliblifuture.repository;

import com.bliblifuture.model.StockOpname;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StockOpnameRepository extends JpaRepository<StockOpname, String> {
    StockOpname findByStockOpnameId(String stockOpnameId);
    List<StockOpname> findByFinishCountingTime(Date date);

}
