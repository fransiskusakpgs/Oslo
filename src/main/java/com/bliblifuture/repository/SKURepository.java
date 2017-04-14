package com.bliblifuture.repository;

import com.bliblifuture.model.SKU;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SKURepository extends JpaRepository<SKU, String>{
}
