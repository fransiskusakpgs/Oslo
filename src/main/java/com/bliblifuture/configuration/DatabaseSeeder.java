package com.bliblifuture.configuration;

import com.bliblifuture.model.*;
import com.bliblifuture.repository.*;
import com.bliblifuture.service.StockOpnameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
public class DatabaseSeeder {
    @Autowired
    AdminRepository adminRepo;
    @Autowired
    CounterRepository counterRepo;
    @Autowired
    StockOpnameRepository stockOpnameRepo;
    @Autowired
    SKURepository skuRepo;
    @Autowired
    SuperAdminRepository superAdminRepo;
    @Autowired
    UnknownSKURepository unknownSKURepo;
    @Autowired
    UserRoleRepository userRoleRepo;
    @Autowired
    WarehouseRepository warehouseRepo;

    @Autowired
    StockOpnameService stockOpnameService;
    @PostConstruct
    private void mockupData(){
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

        SKU skuOne = new SKU();
        skuOne.setSKUid("AAA1111");
        skuOne.setItemName("Agree To Shop Pants");
        skuOne.setDeviationQty(0);
        skuOne.setInformation("");
        skuOne.setStockType("Trading");
        skuOne.setStorageCode("A-101-100");
        skuRepo.save(skuOne);
        skuOne.setPhysicalQty(0);
        skuOne.setSystemQty(1);
        skuRepo.save(skuOne);

        SKU skuTwo = new SKU();
        skuTwo.setSKUid("BBB1111");
        skuTwo.setItemName("Agree To Shop Pants");
        skuTwo.setDeviationQty(0);
        skuTwo.setInformation("");
        skuTwo.setStockType("Trading");
        skuTwo.setStorageCode("A-101-100");
        skuRepo.save(skuTwo);
        skuTwo.setPhysicalQty(0);
        skuTwo.setSystemQty(1);
        skuRepo.save(skuTwo);


        UnknownSKU unknownSKUone = new UnknownSKU();
        unknownSKUone.setUnknownSKUId("SKU-112-001");
        unknownSKUone.setStorageCode("B-101-100");
        unknownSKUone.setPhysicalQty(1);
        unknownSKURepo.save(unknownSKUone);

        UnknownSKU unknownSKUtwo = new UnknownSKU();
        unknownSKUtwo.setUnknownSKUId("SKU-112-001");
        unknownSKUtwo.setStorageCode("B-101-101");
        unknownSKUtwo.setPhysicalQty(1);
        unknownSKURepo.save(unknownSKUtwo);

        StockOpname stockOpnameOne = new StockOpname();
        stockOpnameOne.setStockOpnameId("STO-001-1001");
//      checkDate
        stockOpnameOne.formatWaktuPembuatan("2011/02/01 03:04:01");
        stockOpnameRepo.save(stockOpnameOne);
        stockOpnameOne.setStatus("");
        stockOpnameOne.setStockOpnameId("100");
        stockOpnameRepo.save(stockOpnameOne);
        stockOpnameOne.addSKU(skuOne);
        stockOpnameOne.addSKU(skuTwo);
        stockOpnameOne.addUnknownSKU(unknownSKUone);
        stockOpnameOne.addUnknownSKU(unknownSKUtwo);

//        stockOpnameOne.setUnknownSKUs(UnknownSKUsOne);
        stockOpnameOne.countTotalQty();
        stockOpnameOne.countTotalSKU();
        stockOpnameRepo.save(stockOpnameOne);

//      Admin One Dummy
        Admin adminone = new Admin();
        adminone.setUsername("admin-demo-one");
        adminone.setPassword("123");
        adminone.setStatus("Active");
        adminone.addWarehouse(warehouseOne);
        adminRepo.save(adminone);

        adminone.createEntryUserRole(userRoleRepo);
        adminRepo.save(adminone);

//      Admin Two Dummy
        Admin admintwo = new Admin();
        admintwo.setUsername("admin-demo-two");
        admintwo.setPassword("123");
        admintwo.setStatus("Active");
        admintwo.addWarehouse(warehouseTwo);
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

//      Counter Dummy
        Counter counterOne = new Counter();
        counterOne.createEntryUserRole(userRoleRepo);
        counterOne.setUsername("demo-counter-one");
        counterOne.setPassword("123");
        counterOne.setStatus("Active");
        counterRepo.save(counterOne);
        counterOne.setWarehouse(warehouseOne);
        counterRepo.save(counterOne);

    }
}
