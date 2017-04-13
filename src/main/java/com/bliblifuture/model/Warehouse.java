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
    @ManyToMany
    @JoinColumn(name = "admin_id")
    private List<Admin> admins = new ArrayList<>();

    public void deleteAllAdmin(){
        admins.clear();
    }

    public void deleteAdmin(Admin admin){
        admins.remove(admin);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }

    public void addAdmins(Admin admin){
        this.admins.add(admin);
    }




}
