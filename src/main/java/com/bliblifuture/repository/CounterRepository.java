package com.bliblifuture.repository;

import com.bliblifuture.model.Counter;
import com.bliblifuture.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CounterRepository extends JpaRepository<Counter, String> {
    Counter findByUsername(String username);
    List<Counter> findByWarehouse(Warehouse warehouse);
}
