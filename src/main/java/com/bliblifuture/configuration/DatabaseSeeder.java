package com.bliblifuture.configuration;

import com.bliblifuture.model.SKU;
import com.bliblifuture.model.StockOpname;
import com.bliblifuture.model.UnknownSKU;
import com.bliblifuture.model.WorkList;
import com.bliblifuture.repository.SKURepository;
import com.bliblifuture.repository.StockOpnameRepository;
import com.bliblifuture.repository.UnknownSKURepository;
import com.bliblifuture.repository.WorkListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder {
    @Autowired
    StockOpnameRepository stockOpnameRepo;
    @Autowired
    WorkListRepository workListRepo;
    @Autowired
    SKURepository skuRepo;
    @Autowired
    UnknownSKURepository unknownSKURepo;



    @PostConstruct
    private void mockupData(){

//        WorkList workListOne = new WorkList();
//        workListOne.setSKUs("1A1A");
//        workListRepo.save(workListOne);

        SKU skuOne = new SKU();
        skuOne.setSKUid("AAA1111");
        skuOne.setItemName("Agree To Shop Pants");
        skuOne.setDeviationQty(0);
        skuOne.setInformation("");
        skuOne.setStockType("Trading");
        skuOne.setStorageCode("A-101-100");
        skuRepo.save(skuOne);
        skuOne.setPhysicalQty(0);
        skuOne.setSystemQty(10);
        skuRepo.save(skuOne);

        UnknownSKU unknownSKUone = new UnknownSKU();
        unknownSKUone.setStorageCode("B-101-100");
        unknownSKUone.setPhysicalQty(1);
        unknownSKURepo.save(unknownSKUone);

        SKU skuTwo = new SKU();
        skuTwo.setSKUid("BBB1111");
        skuTwo.setItemName("Agree To Shop Pants");
        skuTwo.setDeviationQty(0);
        skuTwo.setInformation("");
        skuTwo.setStockType("Trading");
        skuTwo.setStorageCode("A-101-100");
        skuRepo.save(skuTwo);
        skuTwo.setPhysicalQty(0);
        skuTwo.setSystemQty(10);
        skuRepo.save(skuTwo);

        UnknownSKU unknownSKUtwo = new UnknownSKU();
        unknownSKUtwo.setStorageCode("B-101-100");
        unknownSKUtwo.setPhysicalQty(1);
        unknownSKURepo.save(unknownSKUtwo);

        List<UnknownSKU> UnknownSKUsOne = new ArrayList<>();
        UnknownSKUsOne.add(unknownSKUone);

        List<UnknownSKU> UnknownSKUsTwo = new ArrayList<>();
        UnknownSKUsTwo.add(unknownSKUtwo);

        StockOpname stockOpnameOne = new StockOpname();
        stockOpnameOne.setStatus("");
        stockOpnameRepo.save(stockOpnameOne);
        stockOpnameOne.addSKU(skuOne);
        stockOpnameOne.addSKU(skuTwo);
        stockOpnameOne.addUnknownSKU(unknownSKUone);
        stockOpnameOne.addUnknownSKU(unknownSKUtwo);

//        stockOpnameOne.setUnknownSKUs(UnknownSKUsOne);
        stockOpnameOne.countTotalQty();
        stockOpnameOne.countTotalSKU();
        stockOpnameOne.setWaktuPembuatan("");
        stockOpnameRepo.save(stockOpnameOne);
//
//        StockOpname stockOpnameTwo = new StockOpname();
//        stockOpnameTwo.setStatus("");
//        stockOpnameRepo.save(stockOpnameTwo);
//        stockOpnameTwo.addSKU(skuThree);
//        stockOpnameTwo.addSKU(skuFour);
//
//        stockOpnameTwo.setUnknownSKUs(UnknownSKUsOne);
//        stockOpnameTwo.countTotalQty();
//        stockOpnameTwo.setWaktuPembuatan("");
//        stockOpnameRepo.save(stockOpnameTwo);
//


//
//        StockOpname stockOpnameTwo = new StockOpname();
//        stockOpnameTwo.setSKUs("BABA");
//        stockOpnameRepo.save(stockOpnameTwo);
//
//        StockOpname stockOpnameThree = new StockOpname();
//        stockOpnameThree.setSKUs("CACA");
//        stockOpnameRepo.save(stockOpnameThree);
//

    }
}
