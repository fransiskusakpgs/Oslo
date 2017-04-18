package com.bliblifuture.configuration;

import com.bliblifuture.model.*;
import com.bliblifuture.repository.*;
import com.bliblifuture.request.StockOpnameRequest;
import com.bliblifuture.request.UnknownSKURequest;
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
        skuOne.setPhysicalQty(9);
        skuOne.setSystemQty(10);
        skuRepo.save(skuOne);

        SKU skuTwo = new SKU();
        skuTwo.setSKUid("BBB1111");
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
        skuThree.setSKUid("SKU-100-111");
        skuThree.setItemName("Agree To Shop Pants");
        skuThree.setDeviationQty(0);
        skuThree.setInformation("COUNTED");
        skuThree.setStockType("Trading");
        skuThree.setStorageCode("A-101-100");
        skuRepo.save(skuThree);
        skuThree.setPhysicalQty(5);
        skuThree.setSystemQty(10);
        skuRepo.save(skuThree);


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

        UnknownSKU unknownSKUthree = new UnknownSKU();
        unknownSKUthree.setUnknownSKUId("SKU-113-001");
        unknownSKUthree.setStorageCode("B-101-101");
        unknownSKUthree.setPhysicalQty(1);
        unknownSKURepo.save(unknownSKUthree);

        StockOpname stockOpnameOne = new StockOpname();
        stockOpnameOne.setStockOpnameId("STO-001-1001");
//      checkDate
        stockOpnameOne.setStringWaktuPembuatan("2011/02/01");
        stockOpnameRepo.save(stockOpnameOne);
        stockOpnameOne.addSKU(skuOne);
        stockOpnameOne.addSKU(skuTwo);
        stockOpnameOne.addUnknownSKU(unknownSKUone);
        stockOpnameOne.addUnknownSKU(unknownSKUtwo);
        stockOpnameOne.countTotalQty();
        stockOpnameOne.countTotalSKU();
        stockOpnameOne.updateStatus();
        stockOpnameOne.startCounting();
        stockOpnameOne.endCounting();
        stockOpnameOne.setStringReportDate("2012/11/02");
        stockOpnameRepo.save(stockOpnameOne);

        StockOpname stockOpnameTwo = new StockOpname();
        stockOpnameTwo.setStockOpnameId("STO-002-1002");
//      checkDate
        stockOpnameTwo.setStringWaktuPembuatan("2011/02/01");
        stockOpnameRepo.save(stockOpnameTwo);
        stockOpnameTwo.addSKU(skuThree);
        stockOpnameTwo.addUnknownSKU(unknownSKUthree);
        stockOpnameTwo.countTotalQty();
        stockOpnameTwo.countTotalSKU();
        stockOpnameTwo.startCounting();
        stockOpnameTwo.setStringReportDate("2012/11/02");
        stockOpnameTwo.endCounting();
        stockOpnameRepo.save(stockOpnameTwo);

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
