package com.bliblifuture.repository;

import com.bliblifuture.model.Admin;
import com.bliblifuture.model.AdminWarehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface AdminWarehouseRepository extends JpaRepository<AdminWarehouse, String>{
    AdminWarehouse findByAdmin(Admin admin);
    @Transactional
    void deleteByAdmin(Admin admin);
}
