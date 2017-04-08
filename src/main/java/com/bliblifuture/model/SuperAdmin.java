package com.bliblifuture.model;

import com.bliblifuture.repository.UserRoleRepository;

import javax.persistence.Entity;

@Entity
public class SuperAdmin extends User {
    public SuperAdmin (){super();}
    public void createEntryUserRole(UserRoleRepository userRoleRepo){
        UserRole superAdminRole = new UserRole();
        superAdminRole.setUsername(this.getUsername());
        superAdminRole.setRole("ROLE_SUPER_ADMIN");
        userRoleRepo.save(superAdminRole);

        this.userRole = superAdminRole;
    }
}
