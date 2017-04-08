package com.bliblifuture.request;

import com.bliblifuture.model.Warehouse;

import java.io.Serializable;
import java.util.List;

public class UserRequest<T> implements Serializable {
    private String username;
    private String passord;
    private String role;
    private List<Warehouse> warehouse;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassord() {
        return passord;
    }

    public void setPassord(String passord) {
        this.passord = passord;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Warehouse> getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(List<Warehouse> warehouse) {
        this.warehouse = warehouse;
    }
}
