package com.bliblifuture.repository;


import com.bliblifuture.model.Counter;
import com.bliblifuture.model.StockOpname;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorklistRepository extends JpaRepository<StockOpname, String> {
List<StockOpname> findStockOpnameByAssignedTo(Counter assignedTo);
}



