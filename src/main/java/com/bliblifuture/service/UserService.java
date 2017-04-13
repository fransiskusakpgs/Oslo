package com.bliblifuture.service;

import com.bliblifuture.model.Admin;
import com.bliblifuture.model.Counter;
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
    CounterRepository counterRepo;
    @Autowired
    UserRepository userRepo;
    @Autowired
    UserRoleRepository userRoleRepo;
    @Autowired
    WarehouseRepository warehouseRepo;

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

    public void editCounter(UserRequest data){
        Counter currentCounter = counterRepo.findByUsername(data.getUsername());
        currentCounter.setPassword(data.getPassword());
        currentCounter.setStatus(data.getStatus());
        counterRepo.save(currentCounter);
    }

    public List<User> findAll(){
        List<User> dataUser = userRepo.findAll();
        return dataUser;
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

    public void registerCounter(UserRequest data){
        Counter newCounter = new Counter();
        newCounter.createEntryUserRole(userRoleRepo);
        counterRepo.save(newCounter);
        newCounter.setUsername(data.getUsername());
        newCounter.setPassword(data.getPassword());
        newCounter.setStatus(data.getStatus());
        Warehouse counterSetWarehouse = warehouseRepo.findByName(data.getWarehouse().get(0));
        newCounter.setWarehouse(counterSetWarehouse);
        counterRepo.save(newCounter);
    }
}
