package com.bliblifuture.repository;

import com.bliblifuture.model.User;
import com.bliblifuture.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
        User findByUsername(String username);
        User findByUserRole(UserRole userRole);
}
