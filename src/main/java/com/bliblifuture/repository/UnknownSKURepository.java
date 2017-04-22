package com.bliblifuture.repository;

import com.bliblifuture.model.UnknownSKU;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnknownSKURepository extends JpaRepository<UnknownSKU, String>{
}
