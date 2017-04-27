package com.bliblifuture.configuration;
import com.bliblifuture.OsloUtils;
import com.bliblifuture.model.SKU;
import com.bliblifuture.model.StockOpname;
import com.bliblifuture.model.UnknownSKU;
import com.bliblifuture.repository.SKURepository;
import com.bliblifuture.repository.StockOpnameRepository;
import com.bliblifuture.repository.UnknownSKURepository;

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

//      -------------------------------------------------------------
//        Warehouse Dummy
//      -------------------------------------------------------------
        Warehouse warehouseOne = new Warehouse();
        warehouseOne.setName("Cawang");
        warehouseRepo.save(warehouseOne);

        Warehouse warehouseTwo = new Warehouse();
        warehouseTwo.setName("Cakung");
        warehouseRepo.save(warehouseTwo);

        Warehouse warehouseThree = new Warehouse();
        warehouseThree.setName("Gudang KS Tubun");
        warehouseRepo.save(warehouseThree);

//      -------------------------------------------------------------
//        Unknown SKU Dummy
//      -------------------------------------------------------------
        SKU skuOne = new SKU();
        skuOne.setSKUid("SKU-001");
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
        skuTwo.setSKUid("SKU-002");
        skuTwo.setItemName("Agree To Shop Pants");
        skuTwo.setDeviationQty(0);
        skuTwo.setInformation("COUNTED");
        skuTwo.setStockType("Trading");
        skuTwo.setStorageCode("A-101-100");
        skuRepo.save(skuTwo);
        skuTwo.setPhysicalQty(7);
        skuTwo.setSystemQty(3);
        skuRepo.save(skuTwo);

        SKU skuThree = new SKU();
        skuThree.setSKUid("SKU-003");
        skuThree.setItemName("Agree To Shop Pants");
        skuThree.setDeviationQty(0);
        skuThree.setInformation("COUNTED");
        skuThree.setStockType("Trading");
        skuThree.setStorageCode("A-101-100");
        skuRepo.save(skuThree);
        skuThree.setPhysicalQty(5);
        skuThree.setSystemQty(10);
        skuRepo.save(skuThree);

//      -------------------------------------------------------------
//        Unknown SKU Dummy
//      -------------------------------------------------------------
        UnknownSKU unknownSKUone = new UnknownSKU();
        unknownSKUone.setUnknownSKUId("SKU-004");
        unknownSKUone.setStorageCode("B-101-100");
        unknownSKUone.setPhysicalQty(1);
        unknownSKURepo.save(unknownSKUone);

        UnknownSKU unknownSKUtwo = new UnknownSKU();
        unknownSKUtwo.setUnknownSKUId("SKU-005");
        unknownSKUtwo.setStorageCode("B-101-101");
        unknownSKUtwo.setPhysicalQty(1);
        unknownSKURepo.save(unknownSKUtwo);

        UnknownSKU unknownSKUthree = new UnknownSKU();
        unknownSKUthree.setUnknownSKUId("SKU-006");
        unknownSKUthree.setStorageCode("B-101-101");
        unknownSKUthree.setPhysicalQty(1);
        unknownSKURepo.save(unknownSKUthree);

//      -------------------------------------------------------------
//        StockOpname Dummy
//      -------------------------------------------------------------
        StockOpname stockOpnameOne = new StockOpname();
        stockOpnameOne.setStockOpnameId("STO-001");
        stockOpnameOne.setStringWaktuPembuatan("2011-02-01");
        stockOpnameRepo.save(stockOpnameOne);
        stockOpnameOne.setReportDate(OsloUtils.convertStringDateToLocalDate("2017-04-24"));
        stockOpnameOne.setStatus("FINISH COUNTING");
        stockOpnameRepo.save(stockOpnameOne);

        StockOpname stockOpnameTwo = new StockOpname();
        stockOpnameTwo.setStockOpnameId("STO-002");
        stockOpnameTwo.setStringWaktuPembuatan("2011-02-01");
        stockOpnameRepo.save(stockOpnameTwo);
        stockOpnameTwo.startCounting();
        stockOpnameTwo.endCounting();
        stockOpnameTwo.reporting();
        stockOpnameRepo.save(stockOpnameTwo);

//      -------------------------------------------------------------
//        Admin Dummy
//      -------------------------------------------------------------

        Admin adminone = new Admin();
        adminone.setUsername("admin-demo-one");
        adminone.setPassword("123");
        adminone.setStatus("Active");
        adminone.addWarehouse(warehouseOne);
        adminRepo.save(adminone);
        adminone.createEntryUserRole(userRoleRepo);
        adminRepo.save(adminone);

        Admin admintwo = new Admin();
        admintwo.setUsername("admin-demo-two");
        admintwo.setPassword("123");
        admintwo.setStatus("Active");
        admintwo.addWarehouse(warehouseTwo);
        adminRepo.save(admintwo);
        admintwo.createEntryUserRole(userRoleRepo);
        adminRepo.save(admintwo);

//      -------------------------------------------------------------
//        SuperAdmin Dummy
//      -------------------------------------------------------------
        SuperAdmin superAdminOne = new SuperAdmin();
        superAdminOne.setUsername("super-admin-demo");
        superAdminOne.setPassword("123");
        superAdminOne.setStatus("Active");
        superAdminRepo.save(superAdminOne);
        superAdminOne.createEntryUserRole(userRoleRepo);
        superAdminRepo.save(superAdminOne);

//      -------------------------------------------------------------
//        Counter Dummy
//      -------------------------------------------------------------
        Counter counterOne = new Counter();
        counterOne.setUsername("demo-counter-one");
        counterOne.setPassword("123");
        counterOne.setStatus("Active");
        counterOne.createEntryUserRole(userRoleRepo);
        counterRepo.save(counterOne);
        counterOne.setWarehouse(warehouseOne);
        counterRepo.save(counterOne);


        skuOne.setStockOpname(stockOpnameOne);
        skuRepo.save(skuOne);

        skuTwo.setStockOpname(stockOpnameOne);
        skuRepo.save(skuTwo);

        unknownSKUone.setStockOpname(stockOpnameOne);
        unknownSKURepo.save(unknownSKUone);

        unknownSKUtwo.setStockOpname(stockOpnameOne);
        unknownSKURepo.save(unknownSKUtwo);
    }
}
