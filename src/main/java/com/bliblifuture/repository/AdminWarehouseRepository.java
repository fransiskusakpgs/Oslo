package com.bliblifuture.repository;

import com.bliblifuture.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface AdminWarehouseRepository extends JpaRepository<AdminWarehouse, String>{
    AdminWarehouse findByAdmin(Admin admin);
    @Transactional
    void deleteByAdmin(Admin admin);
}
