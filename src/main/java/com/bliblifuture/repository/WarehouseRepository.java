package com.bliblifuture.repository;

import com.bliblifuture.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, String> {
    Warehouse findByName(String name);
}
