package com.bliblifuture.model;

import com.bliblifuture.repository.UserRoleRepository;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Admin extends User{

    @OneToMany
    private List<AdminWarehouse> adminWarehouse = new ArrayList<>();

    public Admin(){
        super();
    }

    public void createEntryUserRole(UserRoleRepository userRoleRepo){
        UserRole adminrole = new UserRole();
        adminrole.setRole("ROLE_ADMIN");
        userRoleRepo.save(adminrole);

        this.userRole = adminrole;
}

    public List<String> getWarehouse(){
        List<String> warehouses = new ArrayList<>();
        for (AdminWarehouse adminWarehouse: this.adminWarehouse) {
            Warehouse warehouse = adminWarehouse.getWarehouse();
            String whName = warehouse.getName();
            warehouses.add(whName);
        }
        return warehouses;
    }

    public void setAdminWarehouse(List<AdminWarehouse> adminWarehouse) {
        this.adminWarehouse = adminWarehouse;
    }

    public void addAdminWarehouse(AdminWarehouse adminWarehouse){
        this.adminWarehouse.add(adminWarehouse);
    }

}
