package com.bliblifuture.repository;


import com.bliblifuture.model.StockOpname;
import com.bliblifuture.model.UnknownSKU;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UnknownSKURepository extends JpaRepository<UnknownSKU, String> {
    List <UnknownSKU> findByStockOpname (StockOpname stockOpname);

}
