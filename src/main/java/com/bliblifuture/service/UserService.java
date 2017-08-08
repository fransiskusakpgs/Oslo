package com.bliblifuture.service;

import com.bliblifuture.model.*;
import com.bliblifuture.repository.*;
import com.bliblifuture.request.UserRequest;
import com.bliblifuture.response.UserResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    StockOpnameRepository stockOpnameRepo;

    public boolean editAdmin(UserRequest data) throws Exception {

        if(data.getUsername()== null || data.getUsername().equals("")||
                data.getRole()== null || data.getRole().equals("")||
                data.getStatus()== null || data.getStatus().equals("")||
                data.getPassword()== null || data.getPassword().equals("")) {
            throw new Exception("Neither Username, Password, Role nor Warehouse can be empty!");
        }

        Admin currentAdmin = adminRepo.findByUsername(data.getUsername());
        if(currentAdmin==null){
            throw new Exception("Admin not found");
        }

        if(data.getStatus().equals("Inactive")){
            if(!currentAdmin.getStatus().equals("Active")){
                throw new Exception("Sorry you can't inactive this counter");
            }else{
                currentAdmin.setEnabled(false);
                currentAdmin.setStatus(data.getStatus());
            }
        } else if(data.getStatus().equals("Active")){
            if(currentAdmin.getStatus().equals("Inactive")){
                currentAdmin.setEnabled(true);
                currentAdmin.setStatus(data.getStatus());
            }
        }

        List<String> newWarehouses = data.getWarehouse();
        List<Warehouse> acceptedWarehouses = new ArrayList<>();
            for (String newWarehouse : newWarehouses) {
                Warehouse availableWarehouse = warehouseRepo.findByName(newWarehouse);
                acceptedWarehouses.add(availableWarehouse);
            }
        currentAdmin.setPassword(data.getPassword());
        currentAdmin.setWarehouse(acceptedWarehouses);
        adminRepo.save(currentAdmin);
        return true;
    }

    public boolean editCounter(UserRequest data) throws Exception{
        if(!authenticationService.getAuthenticatedUser().getRole().equals("ROLE_SUPER_ADMIN")){
            throw new IllegalAccessException("Sorry you don't have access to change counter's warehouse! " +
                    "If you want to change counter's warehouse please ask Super Admin!");
        }

        if(data.getUsername()== null || data.getUsername().equals("")||
                data.getRole()== null || data.getRole().equals("")||
                data.getStatus()== null || data.getStatus().equals("")||
                data.getPassword()== null || data.getPassword().equals("")) {
            throw new Exception("Neither Username, Password, Role nor Warehouse can be empty!");
        }

        if(data.getWarehouse().size()!=1){
            throw new Exception("Please check your warehouse input!");
        }

        Counter currentCounter = counterRepo.findByUsername(data.getUsername());
        if(currentCounter==null){
            throw new Exception("Counter not found");
        }

        if(data.getStatus().equals("Inactive")){
            if(!currentCounter.getStatus().equals("Active") ||
                    stockOpnameRepo.findByAssignedTo(currentCounter).size()!=0){
                throw new Exception("Sorry you can't inactive this counter");
            }else{
                currentCounter.setEnabled(false);
                currentCounter.setStatus(data.getStatus());
            }
        } else if(data.getStatus().equals("Active")){
            if(currentCounter.getStatus().equals("Inactive")){
                currentCounter.setEnabled(true);
                currentCounter.setStatus(data.getStatus());
            }
        }

        currentCounter.setPassword(data.getPassword());
        currentCounter.setWarehouse(warehouseRepo.findByName(data.getWarehouse().get(0)));
        counterRepo.save(currentCounter);

        return true;
    }

    public List<User> findAll(String username, String warehouse){
        UserRole userRole = userRoleRepo.findByUsername(username);
        List<User> listUser = new ArrayList<>();
        if (userRole.getRole().equals("ROLE_ADMIN")){
            Warehouse warehouseActive = warehouseRepo.findByName(warehouse);
            List<Counter> listCounter = counterRepo.findByWarehouse(warehouseActive);
            for (Counter counter: listCounter) {
                User dataUser = (User)counter;
                listUser.add(dataUser);
            }
            return listUser;
        }
        else if(userRole.getRole().equals("ROLE_SUPER_ADMIN")){
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
        newAdmin.setWarehouse(acceptedWarehouses);
        adminRepo.save(newAdmin);
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

    public UserResponse getUserData(String username){
        UserResponse userData = new UserResponse();
        User user = userRepo.findByUsername(username);
        BeanUtils.copyProperties(user,userData);
        UserRole userRole = userRoleRepo.findByUsername(username);
        String role = userRole.getRole();
        userData.setRole(role);
        System.out.println(role);
        List<Warehouse> warehouseList = new ArrayList<>();
        if(role.equals("ROLE_ADMIN")){
            Admin admin = adminRepo.findByUsername(username);
            warehouseList  = admin.getWarehouse();
            System.out.println(warehouseList.get(0));
        }else if(role.equals("ROLE_COUNTER")){
            Counter counter = counterRepo.findByUsername(username);
            Warehouse warehouse = counter.getWarehouse();
            warehouseList.add(warehouse);
        }
        List<String> warehouseListString = new ArrayList<>();
        for (Warehouse warehouse:warehouseList) {
            warehouseListString.add(warehouse.getName());
        }
        userData.setWarehouse(warehouseListString);
        return userData;
    }
}
