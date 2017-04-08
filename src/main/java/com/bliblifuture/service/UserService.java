package com.bliblifuture.service;

import com.bliblifuture.model.Admin;
import com.bliblifuture.model.User;
import com.bliblifuture.model.Warehouse;
import com.bliblifuture.repository.AdminRepository;
import com.bliblifuture.repository.UserRepository;
import com.bliblifuture.repository.UserRoleRepository;
import com.bliblifuture.repository.WarehouseRepository;
import com.bliblifuture.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepo;
    @Autowired
    UserRoleRepository userRoleRepo;
    @Autowired
    AdminRepository adminRepo;
    @Autowired
    WarehouseRepository warehouseRepo;

    public List<User> findAll(){
        List<User> data = userRepo.findAll();
        return data;
    }

    public void registerAdmin(UserRequest data){
        Admin newAdmin = new Admin();
        newAdmin.createEntryUserRole(userRoleRepo);
        adminRepo.save(newAdmin);
        newAdmin.setUsername(data.getUsername());
        newAdmin.setPassword(data.getPassword());
        newAdmin.setStatus(data.getStatus());
        adminRepo.save(newAdmin);

        List<Warehouse> listOfWarehouse = new ArrayList<>();
        List<String> warehouses = new ArrayList<>();

        for (String warehouse: warehouses) {
            Warehouse addingWarehouse = new Warehouse();
            addingWarehouse.setName(warehouse);
            warehouseRepo.save(addingWarehouse);
            listOfWarehouse.add(addingWarehouse);
        }

        newAdmin.setWarehouse(listOfWarehouse);
        adminRepo.save(newAdmin);

    }
}
