package com.bliblifuture.repository;

import com.bliblifuture.model.StockOpname;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface StockOpnameRepository extends JpaRepository<StockOpname, String> {


}
