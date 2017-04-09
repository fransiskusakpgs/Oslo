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
    @Autowired
    AdminWarehouseRepository adminWarehouseRepo;

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

//      Admin One Dummy
        Admin adminone = new Admin();
        adminone.setUsername("admin-demo-one");
        adminone.setPassword("123");
        adminone.setStatus("Active");
        adminRepo.save(adminone);

        adminone.createEntryUserRole(userRoleRepo);
        adminRepo.save(adminone);

//      AdminWarehouse One Dummy
        AdminWarehouse adminWarehouseOne = new AdminWarehouse();
        adminWarehouseOne.setAdmin(adminone);
        adminWarehouseOne.setWarehouse(warehouseOne);
        adminWarehouseRepo.save(adminWarehouseOne);

        adminone.addAdminWarehouse(adminWarehouseOne);
        adminRepo.save(adminone);

//      Admin Two Dummy
        Admin admintwo = new Admin();
        admintwo.setUsername("admin-demo-two");
        admintwo.setPassword("123");
        admintwo.setStatus("Active");
        adminRepo.save(admintwo);

        admintwo.createEntryUserRole(userRoleRepo);
        adminRepo.save(admintwo);

//      AdminWarehouse Dummy
        AdminWarehouse adminWarehouseTwo = new AdminWarehouse();
        adminWarehouseTwo.setAdmin(admintwo);
        adminWarehouseTwo.setWarehouse(warehouseOne);
        adminWarehouseRepo.save(adminWarehouseTwo);

        admintwo.addAdminWarehouse(adminWarehouseTwo);

//      AdminWarehouse Dummy
        AdminWarehouse adminWarehouseThree = new AdminWarehouse();
        adminWarehouseThree.setAdmin(admintwo);
        adminWarehouseThree.setWarehouse(warehouseTwo);
        adminWarehouseRepo.save(adminWarehouseThree);

        admintwo.addAdminWarehouse(adminWarehouseThree);
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
