package com.bliblifuture.service;

import com.bliblifuture.model.Admin;
import com.bliblifuture.model.AdminWarehouse;
import com.bliblifuture.model.User;
import com.bliblifuture.model.Warehouse;
import com.bliblifuture.repository.*;
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
    @Autowired
    AdminWarehouseRepository adminWarehouseRepo;

    public List<User> findAll(){
        List<User> data = userRepo.findAll();
        return data;
    }

    public void registerAdmin(UserRequest data){
//      Membuat admin
        Admin newAdmin = new Admin();
        newAdmin.createEntryUserRole(userRoleRepo);
        adminRepo.save(newAdmin);

//      Mengisi atribut admin
        newAdmin.setUsername(data.getUsername());
        newAdmin.setPassword(data.getPassword());
        newAdmin.setStatus(data.getStatus());
        adminRepo.save(newAdmin);

//      Membuat warehouse
        AdminWarehouse adminWarehouse = new AdminWarehouse();

        for (String warehouse: data.getWarehouse()) {

//          Merubah string warehouse menjadi Warehouse addingWarehouse
            Warehouse addingWarehouse = new Warehouse();
            addingWarehouse.setName(warehouse);
            warehouseRepo.save(addingWarehouse);

//          Merubah Warehouse addingWarehouse menjadi AdminWarehouse adminWarehouse
            adminWarehouse.setWarehouse(addingWarehouse);
            adminWarehouseRepo.save(adminWarehouse);

//          Menambahkan AdminWarehouse adminWarehouse kedalam newAdmin dalam bentuk List<AdminWarehouse>
            newAdmin.addAdminWarehouse(adminWarehouse);
            adminRepo.save(newAdmin);
        }
        adminRepo.save(newAdmin);
    }
}
