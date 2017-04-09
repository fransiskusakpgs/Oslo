package com.bliblifuture.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @OneToMany
    private List<AdminWarehouse> adminWarehouse = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AdminWarehouse> getAdminWarehouse() {
        return adminWarehouse;
    }

    public void setAdminWarehouse(List<AdminWarehouse> adminWarehouse) {
        this.adminWarehouse = adminWarehouse;
    }

    public void addAdminWarehouse(AdminWarehouse adminWarehouse){
        this.adminWarehouse.add(adminWarehouse);
    }
}
