package com.bliblifuture.repository;

import com.bliblifuture.model.AdminWarehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminWarehouseRepository extends JpaRepository<AdminWarehouse, String> {
}
