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
        unknownSKUone.setUnknownSKUId("US-1001");
        unknownSKUone.setStorageCode("B-101-100");
        unknownSKUone.setPhysicalQty(1);
        unknownSKURepo.save(unknownSKUone);

        UnknownSKU unknownSKUtwo = new UnknownSKU();
        unknownSKUtwo.setUnknownSKUId("US-1002");
        unknownSKUtwo.setStorageCode("B-101-101");
        unknownSKUtwo.setPhysicalQty(1);
        unknownSKURepo.save(unknownSKUtwo);

        List<UnknownSKU> unknownSKUsOnes = new ArrayList<>();
        unknownSKUsOnes.add(unknownSKUone);
        unknownSKUsOnes.add(unknownSKUtwo);

        List<SKU> gabungan = new ArrayList<>();
        gabungan.add(skuOne);
        gabungan.add(skuTwo);

        StockOpname stockOpnameOne = new StockOpname();
        stockOpnameOne.setStatus("Halo");
        stockOpnameOne.setStockOpnameId("100");
        stockOpnameRepo.save(stockOpnameOne);

//        stockOpnameOne.addSKU(skuOne);
//        stockOpnameOne.addSKU(skuTwo);
//        stockOpnameOne.setSKUs(gabungan);
//        stockOpnameRepo.save(stockOpnameOne); //frans

        skuOne.setStockOpname(stockOpnameOne);
        skuRepo.save(skuOne);

        skuTwo.setStockOpname(stockOpnameOne);
        skuRepo.save(skuTwo);
//        stockOpnameOne.setUnknownSKUs(unknownSKUsOnes);
//        stockOpnameOne.addUnknownSKU(unknownSKUone);

        unknownSKUone.setStockOpname(stockOpnameOne);
        unknownSKURepo.save(unknownSKUone);


//        stockOpnameOne.addUnknownSKU(unknownSKUtwo);
        unknownSKUtwo.setStockOpname(stockOpnameOne);
        unknownSKURepo.save(unknownSKUtwo);
//        stockOpnameOne.countTotalQty();
//        stockOpnameOne.countTotalSKU();
        stockOpnameOne.setWaktuPembuatan("11/01/2016");
        stockOpnameRepo.save(stockOpnameOne);
    }
}
