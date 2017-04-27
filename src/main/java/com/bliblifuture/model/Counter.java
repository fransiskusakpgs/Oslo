package com.bliblifuture.model;

import com.bliblifuture.repository.UserRoleRepository;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Counter extends User {
    @OneToOne
    @JoinColumn(name = "warehouse_id")
    private  Warehouse warehouse;

    public Counter (){super();}

    public void createEntryUserRole(UserRoleRepository userRoleRepo){
        UserRole counterRole = new UserRole();
        counterRole.setUsername(this.getUsername());
        counterRole.setRole("ROLE_COUNTER");
        userRoleRepo.save(counterRole);

        this.userRole = counterRole;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}
