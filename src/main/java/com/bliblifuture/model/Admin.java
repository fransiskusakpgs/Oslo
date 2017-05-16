package com.bliblifuture.model;

import com.bliblifuture.repository.UserRoleRepository;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Admin extends User{

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "warehouse_id")
    private List<Warehouse> warehouses = new ArrayList<>();

    public Admin(){
        super();
    }

    public void addWarehouse(Warehouse warehouse){
        this.warehouses.add(warehouse);
    }

    public void createEntryUserRole(UserRoleRepository userRoleRepo){
        UserRole adminrole = new UserRole();
        adminrole.setUsername(this.getUsername());
        adminrole.setRole("ROLE_ADMIN");
        userRoleRepo.save(adminrole);

        this.userRole = adminrole;
    }

    public List<Warehouse> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(List<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }

}

