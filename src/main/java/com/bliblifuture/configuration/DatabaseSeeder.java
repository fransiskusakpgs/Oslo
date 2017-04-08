package com.bliblifuture.configuration;

import com.bliblifuture.model.*;
import com.bliblifuture.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class DatabaseSeeder {
    @Autowired
    StockOpnameRepository stockOpnameRepo;
    @Autowired
    WarehouseRepository warehouseRepo;
    @Autowired
    AdminRepository adminRepo;
    @Autowired
    UserRoleRepository userRoleRepo;
    @Autowired
    SuperAdminRepository superAdminRepo;

    @PostConstruct
    private void mockupData(){

//      StockOpname Dummy
        StockOpname stockOpnameOne = new StockOpname();
        stockOpnameOne.setSKU("ABAB");
        stockOpnameRepo.save(stockOpnameOne);

        StockOpname stockOpnameTwo = new StockOpname();
        stockOpnameTwo.setSKU("BABA");
        stockOpnameRepo.save(stockOpnameTwo);

        StockOpname stockOpnameThree = new StockOpname();
        stockOpnameThree.setSKU("CACA");
        stockOpnameRepo.save(stockOpnameThree);

//      Warehouse Dummy
        Warehouse warehouseOne = new Warehouse();
        warehouseOne.setName("Cawang");
        warehouseRepo.save(warehouseOne);

        Warehouse warehouseTwo = new Warehouse();
        warehouseTwo.setName("Cakung");
        warehouseRepo.save(warehouseTwo);

        Warehouse warehouseThree = new Warehouse();
        warehouseThree.setName("Gudang KS Tubun");
        warehouseRepo.save(warehouseThree);

//      ListWarehouse Dummy
        List<Warehouse> warehouseList = new ArrayList<>();
        warehouseList.add(warehouseOne);

//      Admin Dummy
        Admin adminone = new Admin();
        adminone.setUsername("admin-demo-one");
        adminone.setPassword("123");
        adminone.setStatus("Active");
        adminone.setWarehouse(warehouseList);
        adminRepo.save(adminone);
        adminone.createEntryUserRole(userRoleRepo);
        adminRepo.save(adminone);

        Admin admintwo = new Admin();
        admintwo.setUsername("admin-demo-two");
        admintwo.setPassword("123");
        admintwo.setStatus("Active");
        adminone.setWarehouse(warehouseList);
        adminRepo.save(admintwo);
        admintwo.createEntryUserRole(userRoleRepo);
        adminRepo.save(admintwo);

//      SuperAdmin Dummy
        SuperAdmin superAdminOne = new SuperAdmin();
        superAdminOne.setUsername("super-admin-demo");
        superAdminOne.setPassword("123");
        superAdminOne.setStatus("Active");
        superAdminRepo.save(superAdminOne);
        superAdminOne.createEntryUserRole(userRoleRepo);
        superAdminRepo.save(superAdminOne);

    }
}
