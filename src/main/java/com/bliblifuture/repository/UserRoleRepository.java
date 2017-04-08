package com.bliblifuture.repository;

import com.bliblifuture.model.UserRole;
import com.bliblifuture.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, String> {
}
