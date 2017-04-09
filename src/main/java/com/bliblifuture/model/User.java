package com.bliblifuture.model;

import javax.persistence.*;

@Entity
@Table(name="oslo_user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username;
    private String password;
    private String status;

    @OneToOne
    protected UserRole userRole;

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

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public String getRole() {
        return userRole.role;
    }
}
