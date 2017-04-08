package com.bliblifuture.configuration;

import com.bliblifuture.model.Admin;
import com.bliblifuture.model.StockOpname;
import com.bliblifuture.model.User;
import com.bliblifuture.model.Warehouse;
import com.bliblifuture.repository.AdminRepository;
import com.bliblifuture.repository.StockOpnameRepository;
import com.bliblifuture.repository.UserRoleRepository;
import com.bliblifuture.repository.WarehouseRepository;
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

    @PostConstruct
    private void mockupData(){
        StockOpname stockOpnameOne = new StockOpname();
        stockOpnameOne.setSKU("ABAB");
        stockOpnameRepo.save(stockOpnameOne);

        StockOpname stockOpnameTwo = new StockOpname();
        stockOpnameTwo.setSKU("BABA");
        stockOpnameRepo.save(stockOpnameTwo);

        StockOpname stockOpnameThree = new StockOpname();
        stockOpnameThree.setSKU("CACA");
        stockOpnameRepo.save(stockOpnameThree);

        Warehouse warehouseOne = new Warehouse();
        warehouseOne.setName("Cawang");
        warehouseRepo.save(warehouseOne);

        Warehouse warehouseTwo = new Warehouse();
        warehouseTwo.setName("Cakung");
        warehouseRepo.save(warehouseTwo);

        Warehouse warehouseThree = new Warehouse();
        warehouseThree.setName("Gudang KS Tubun");
        warehouseRepo.save(warehouseThree);

        List<Warehouse> warehouseList = new ArrayList<>();
        warehouseList.add(warehouseOne);

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

    }
}
