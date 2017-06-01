package com.bliblifuture.service;

import com.bliblifuture.model.User;
import com.bliblifuture.model.Warehouse;
import com.bliblifuture.repository.AdminRepository;
import com.bliblifuture.repository.WarehouseRepository;
import com.bliblifuture.request.WarehouseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseService {

    @Autowired
    WarehouseRepository warehouseRepo;
    @Autowired
    AuthenticationService authenticationService;
    @Autowired
    AdminRepository adminRepo;

    public List<Warehouse> findAll(){
        List<Warehouse> data = warehouseRepo.findAll();
        return data;
    }
    public List<Warehouse> findWarehouseByAdmin() throws Exception{
        User currentUser = authenticationService.getAuthenticatedUser();
        if(!currentUser.getRole().equals("ROLE_ADMIN")){
            throw new Exception("This user can't access this api");
        }

        List<Warehouse> warehouses = adminRepo.findByUsername(currentUser.getUsername()).getWarehouse();
        return warehouses;
    }

    public boolean changeWarehouseActive (WarehouseRequest request) throws Exception {
        User currentUser = authenticationService.getAuthenticatedUser();
        List<Warehouse> warehouses = adminRepo.findByUsername(currentUser.getUsername()).getWarehouse();
        Warehouse selectedWarehouse = warehouseRepo.findByName(request.getData());
        if (warehouses.contains(selectedWarehouse)) {
            return true;
        }else{
            throw new Exception("You're not allowed to access this warehouse");
        }
    }
}
