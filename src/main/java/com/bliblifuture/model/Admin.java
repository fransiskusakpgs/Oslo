package com.bliblifuture.model;

import com.bliblifuture.repository.UserRoleRepository;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Admin extends User{

    @ManyToMany
    @JoinColumn(name="admin_id")
    private List<Warehouse> warehouse = new ArrayList<>();

    public Admin(){
        super();
    }

    public void createEntryUserRole(UserRoleRepository userRoleRepo){
        UserRole adminrole = new UserRole();
        adminrole.setUsername(this.getUsername());
        adminrole.setUserRole("ROLE_ADMIN");
        userRoleRepo.save(adminrole);
    }

    public List<Warehouse> getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(List<Warehouse> warehouse) {
        this.warehouse = warehouse;
    }
}
