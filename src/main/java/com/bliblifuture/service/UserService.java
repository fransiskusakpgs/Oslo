package com.bliblifuture.service;

import com.bliblifuture.model.Admin;
import com.bliblifuture.model.AdminWarehouse;
import com.bliblifuture.model.User;
import com.bliblifuture.model.Warehouse;
import com.bliblifuture.repository.*;
import com.bliblifuture.request.UserRequest;
import com.bliblifuture.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    AdminRepository adminRepo;
    @Autowired
    AdminWarehouseRepository adminWarehouseRepo;
    @Autowired
    UserRepository userRepo;
    @Autowired
    UserRoleRepository userRoleRepo;
    @Autowired
    WarehouseRepository warehouseRepo;


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

//      Mendapatkan semua warehouse yang ada di database
        List<Warehouse> availableWarehouses = warehouseRepo.findAll();

        for (String requestWarehouse: data.getWarehouse()) {
//          Melakukan pengecekan apakah requestWarehouse ada di availableWarehouse
            for (Warehouse availableWarehouse: availableWarehouses) {
                if (availableWarehouse.getName().equals(requestWarehouse)){
//                  Membuat adminWarehouse
                    AdminWarehouse adminWarehouse = new AdminWarehouse();
                    adminWarehouse.setAdmin(newAdmin);
                    adminWarehouse.setWarehouse(availableWarehouse);
                    adminWarehouseRepo.save(adminWarehouse);
//                  Menambahkan AdminWarehouse adminWarehouse kedalam newAdmin dalam bentuk List<AdminWarehouse>
                    newAdmin.addAdminWarehouse(adminWarehouse);
                    adminRepo.save(newAdmin);
                }
            }
        }
    }
}
