package com.bliblifuture.service;

import com.bliblifuture.OsloUtils;
import com.bliblifuture.model.*;
import com.bliblifuture.repository.*;
import com.bliblifuture.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    AdminRepository adminRepo;
    @Autowired
    CounterRepository counterRepo;
    @Autowired
    UserRepository userRepo;
    @Autowired
    UserRoleRepository userRoleRepo;
    @Autowired
    WarehouseRepository warehouseRepo;
    @Autowired
    AuthenticationService authenticationService;

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

    public List<User> findAll(String username, String warehouse){
        List<UserRole> userRole = userRoleRepo.findByUsername(username);
        List<User> listUser = new ArrayList<>();
        if (userRole.get(0).getRole().equals("ROLE_ADMIN")){
            Warehouse warehouseActive = warehouseRepo.findByName(warehouse);
            List<Counter> listCounter = counterRepo.findByWarehouse(warehouseActive);
            for (Counter counter: listCounter) {
                User dataUser = (User)counter;
                listUser.add(dataUser);
            }
            return listUser;
        }
        else if(userRole.get(0).getRole().equals("ROLE_SUPER_ADMIN")){
            List<UserRole> listUserRoleAdmin = userRoleRepo.findByRole("ROLE_ADMIN");
            for (UserRole dataUserRole: listUserRoleAdmin) {
                User dataUser = userRepo.findByUserRole(dataUserRole);
                listUser.add(dataUser);
            }
            List<UserRole> listUserRoleCounter = userRoleRepo.findByRole("ROLE_COUNTER");
            for (UserRole dataUserRole: listUserRoleCounter) {
                User dataUser = userRepo.findByUserRole(dataUserRole);
                listUser.add(dataUser);
            }

            return listUser;
        }
        return null;
    }

    public void registerAdmin(UserRequest data) throws IllegalArgumentException{

        if(authenticationService.getAuthenticatedUser()
                .getRole().equals("ROLE_ADMIN")){
            throw new IllegalArgumentException("Sorry you're not allowed to register admin!");
        }

//      Membuat admin
        Admin newAdmin = new Admin();
        newAdmin.setUsername(data.getUsername());
        newAdmin.createEntryUserRole(userRoleRepo);
        adminRepo.save(newAdmin);

//      Mengisi atribut admin
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

    public void registerCounter(UserRequest data)throws IllegalArgumentException{

        if(data.getWarehouse().size()!=1){
            throw new IllegalArgumentException("Counter not allowed have more than one warehouse!");
        }

        Counter newCounter = new Counter();
        newCounter.setUsername(data.getUsername());
        newCounter.createEntryUserRole(userRoleRepo);
        counterRepo.save(newCounter);
        newCounter.setPassword(data.getPassword());
        newCounter.setStatus(data.getStatus());
        Warehouse counterSetWarehouse = warehouseRepo.findByName(data.getWarehouse().get(0));
        newCounter.setWarehouse(counterSetWarehouse);
        counterRepo.save(newCounter);
    }
}
