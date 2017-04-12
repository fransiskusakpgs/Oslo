package com.bliblifuture.service;

import com.bliblifuture.model.Admin;
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
       List<User> dataUser = userRepo.findAll();
       List<Warehouse> coba = warehouseRepo.findByAdmins(adminRepo.findByUsername("demo-admin-one"));
        for (Warehouse w: coba) {
            System.out.println("ini adalah" + w.getName());
        }
        return dataUser;
    }

    public void editAdmin(UserRequest data) {
        Admin currentAdmin = adminRepo.findByUsername(data.getUsername());
        currentAdmin.setPassword(data.getPassword());
        currentAdmin.setStatus(data.getStatus());
        adminRepo.save(currentAdmin);

        currentAdmin.deleteAllWarehouse();
        List<String> newWarehouses = data.getWarehouse();
        List<Warehouse> acceptedWarehouses = new ArrayList<>();
            for (String newWarehouse : newWarehouses) {
                Warehouse availableWarehouse = warehouseRepo.findByName(newWarehouse);
                acceptedWarehouses.add(availableWarehouse);
            }
        currentAdmin.setWarehouses(acceptedWarehouses);
        adminRepo.save(currentAdmin);
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
        List<Warehouse> acceptedWarehouses = new ArrayList<>();

        for (String requestWarehouse: data.getWarehouse()) {
//          Melakukan pengecekan apakah requestWarehouse ada di availableWarehouse
            for (Warehouse availableWarehouse: availableWarehouses) {
                if (availableWarehouse.getName().equals(requestWarehouse)){
                    acceptedWarehouses.add(availableWarehouse);
                }
            }
        }
        newAdmin.setWarehouses(acceptedWarehouses);
    }
}
