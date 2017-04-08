package com.bliblifuture.request;

import java.io.Serializable;
import java.util.List;

public class UserRequest implements Serializable {
    private String username;
    private String password;
    private String status;
    private String role;
    private List<String> warehouse;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<String> getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(List<String> warehouse) {
        this.warehouse = warehouse;
    }
}