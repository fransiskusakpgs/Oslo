package com.bliblifuture.repository;

import com.bliblifuture.model.UserRole;
import com.bliblifuture.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, String> {
    List<UserRole> findByUsername(String username);
}
