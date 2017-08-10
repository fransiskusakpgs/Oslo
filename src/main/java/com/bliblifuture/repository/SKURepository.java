package com.bliblifuture.repository;

import com.bliblifuture.model.SKU;
import com.bliblifuture.model.StockOpname;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SKURepository extends JpaRepository<SKU, String> {
    List<SKU> findByStockOpname (StockOpname stockOpname);
    SKU findByskuId (String skuId);
    SKU findByStorageCode(String storageCode);
    //string dan Id jadi parameter ngesearchnya

}
