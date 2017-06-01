package com.bliblifuture.response;

import java.util.List;

public class UserResponse {
    private String username;
    private String role;
    private String status;
    private List<String> warehouse;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(List<String> warehouse) {
        this.warehouse = warehouse;
    }
}
