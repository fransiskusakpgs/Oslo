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
//      SKU Dummy
//      -------------------------------------------------------------
        SKU skuOne = new SKU();
        skuOne.setSkuId("SKU-001");
        skuOne.setItemName("Agree To Shop Pants");
        skuOne.setDeviationQty(0);
        skuOne.setInformation("COUNTED");
        skuOne.setStockType("Trading");
        skuOne.setStorageCode("A-101-100");
        skuRepo.save(skuOne);
        skuOne.setSystemQty(5);
        skuRepo.save(skuOne);

        SKU skuTwo = new SKU();
        skuTwo.setSkuId("SKU-002");
        skuTwo.setItemName("Agree To Shop Pants");
        skuTwo.setDeviationQty(0);
        skuTwo.setInformation("COUNTED");
        skuTwo.setStockType("Trading");
        skuTwo.setStorageCode("A-101-101");
        skuRepo.save(skuTwo);
        skuTwo.setSystemQty(10);
        skuRepo.save(skuTwo);

        SKU skuThree = new SKU();
        skuThree.setSkuId("SKU-003");
        skuThree.setItemName("Agree To Shop Pants");
        skuThree.setDeviationQty(0);
        skuThree.setInformation("COUNTED");
        skuThree.setStockType("Trading");
        skuThree.setStorageCode("A-101-102");
        skuRepo.save(skuThree);
        skuThree.setSystemQty(10);
        skuRepo.save(skuThree);

        SKU skuFour = new SKU();
        skuFour.setSkuId("SKU-004");
        skuFour.setItemName("Agree To Shop Pants");
        skuFour.setDeviationQty(0);
        skuThree.setInformation("COUNTED");
        skuFour.setStockType("Trading");
        skuFour.setStorageCode("A-101-103");
        skuRepo.save(skuFour);
        //skuThree.setPhysicalQty(5);
        skuThree.setSystemQty(10);
        skuRepo.save(skuFour);

        SKU skuFive = new SKU();
        skuFive.setSkuId("SKU-004");
        skuFive.setItemName("Agree To Shop Pants");
        skuFive.setDeviationQty(0);
        skuThree.setInformation("COUNTED");
        skuFive.setStockType("Trading");
        skuFive.setStorageCode("A-101-104");
        skuRepo.save(skuFive);
        //skuThree.setPhysicalQty(5);
        skuFive.setSystemQty(10);
        skuRepo.save(skuFive);

        SKU skuSix = new SKU();
        skuSix.setSkuId("SKU-004");
        skuSix.setItemName("Agree To Shop Pants");
        skuSix.setDeviationQty(0);
        skuThree.setInformation("COUNTED");
        skuSix.setStockType("Trading");
        skuSix.setStorageCode("A-101-103");
        skuRepo.save(skuSix);
        //skuThree.setPhysicalQty(5);
        skuSix.setSystemQty(10);
        skuRepo.save(skuSix);


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
//        stockOpnameOne.startCounting();
//        stockOpnameOne.endCounting();
        stockOpnameRepo.save(stockOpnameOne);
        stockOpnameOne.setReportDate(OsloUtils.convertStringDateToLocalDate("2017-04-24"));
        stockOpnameOne.setStatus("ASSIGNED");
        stockOpnameRepo.save(stockOpnameOne);

        StockOpname stockOpnameTwo = new StockOpname();
        stockOpnameTwo.setStockOpnameId("STO-002");
        stockOpnameTwo.setStringWaktuPembuatan("2011-02-01");
        stockOpnameRepo.save(stockOpnameTwo);
        stockOpnameTwo.startCounting();
//        stockOpnameTwo.endCounting();
        stockOpnameTwo.reporting();
        stockOpnameRepo.save(stockOpnameTwo);

        StockOpname stockOpnameThree = new StockOpname();
        stockOpnameThree.setStockOpnameId("STO-003");
        stockOpnameThree.setStringWaktuPembuatan("2011-02-04");
        stockOpnameThree.updateStatus();
        stockOpnameRepo.save(stockOpnameThree);

        StockOpname stockOpnameFour = new StockOpname();
        stockOpnameFour.setStockOpnameId("STO-004");
        stockOpnameFour.setStringWaktuPembuatan("2011-02-04");
        stockOpnameFour.updateStatus();
        stockOpnameRepo.save(stockOpnameFour);

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

        Counter counterTwo = new Counter();
        counterTwo.setUsername("demo-counter-two");
        counterTwo.setPassword("123");
        counterTwo.setStatus("Active");
        counterTwo.createEntryUserRole(userRoleRepo);
        counterRepo.save(counterTwo);
        counterTwo.setWarehouse(warehouseTwo);
        counterRepo.save(counterTwo);

        stockOpnameOne.setAssignedTo(counterOne);
        stockOpnameRepo.save(stockOpnameOne);

        stockOpnameTwo.setAssignedTo(counterOne);
        stockOpnameRepo.save(stockOpnameTwo);

        skuOne.setStockOpname(stockOpnameOne);
        skuRepo.save(skuOne);

        skuTwo.setStockOpname(stockOpnameOne);
        skuRepo.save(skuTwo);

        skuThree.setStockOpname(stockOpnameTwo);
        skuRepo.save(skuThree);

        skuFour.setStockOpname(stockOpnameTwo);
        skuRepo.save(skuFour);

        skuFive.setStockOpname(stockOpnameThree);
        skuRepo.save(skuFive);

        skuSix.setStockOpname(stockOpnameFour);
        skuRepo.save(skuSix);

        unknownSKUone.setStockOpname(stockOpnameOne);
        unknownSKURepo.save(unknownSKUone);

        unknownSKUtwo.setStockOpname(stockOpnameOne);
        unknownSKURepo.save(unknownSKUtwo);

        stockOpnameOne.setTotalQty(15);
        stockOpnameOne.setTotalSKU(2);
        stockOpnameRepo.save(stockOpnameOne);

        System.out.println(stockOpnameOne.getTotalQty());

        stockOpnameTwo.setTotalQty(20);
        stockOpnameTwo.setTotalSKU(1);
        stockOpnameRepo.save(stockOpnameTwo);

        stockOpnameThree.setTotalQty(10);
        stockOpnameThree.setTotalSKU(1);
        stockOpnameRepo.save(stockOpnameThree);

        stockOpnameFour.setTotalQty(10);
        stockOpnameFour.setTotalSKU(1);
        stockOpnameRepo.save(stockOpnameFour);
    }

}
