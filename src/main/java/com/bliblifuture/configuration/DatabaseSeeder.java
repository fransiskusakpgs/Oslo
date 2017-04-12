package com.bliblifuture.configuration;

import com.bliblifuture.model.SKU;
import com.bliblifuture.model.StockOpname;
import com.bliblifuture.model.UnknownSKU;
import com.bliblifuture.model.WorkList;
import com.bliblifuture.repository.SKURepository;
import com.bliblifuture.repository.StockOpnameRepository;
import com.bliblifuture.repository.UnknownSKURepository;
import com.bliblifuture.repository.WorkListRepository;
import com.bliblifuture.request.StockOpnameRequest;
import com.bliblifuture.request.UnknownSKURequest;
import com.bliblifuture.service.StockOpnameService;
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

    @Autowired
    StockOpnameService stockOpnameService;
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
        skuOne.setSystemQty(1);
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
        skuTwo.setSystemQty(1);
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
        stockOpnameOne.setStockOpnameId("100");
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

//        UnknownSKURequest usr = new UnknownSKURequest();
//        usr.setUnknownSKUid("10001");
//        usr.setStorageCode("10000");
//        usr.setPhysicalQty(2);
//
//        StockOpnameRequest str = new StockOpnameRequest();
//        str.setStockOpnameId("100");
//        str.setUnknownSKUs(usr);
//
//        stockOpnameService.addUnknownSKUtoList(str);

    }
}
