package com.bliblifuture.repository;

import com.bliblifuture.model.Admin;
import com.bliblifuture.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, String> {
    Warehouse findByName(String name);
}
