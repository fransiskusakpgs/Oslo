package com.bliblifuture.service;

import com.bliblifuture.model.SKU;
import com.bliblifuture.model.StockOpname;
import com.bliblifuture.model.UnknownSKU;
import com.bliblifuture.repository.SKURepository;
import com.bliblifuture.repository.StockOpnameRepository;
import com.bliblifuture.repository.UnknownSKURepository;
import com.bliblifuture.request.SKURequest;
import com.bliblifuture.request.StockOpnameRequest;
import com.bliblifuture.request.UnknownSKURequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockOpnameService {
    @Autowired
    StockOpnameRepository stockOpnameRepo;
    @Autowired
    SKURepository skuRepo;
    @Autowired
    UnknownSKURepository unknownSKURepo;


    public List<StockOpname> findAll(){
        List<StockOpname> data2 = stockOpnameRepo.findAll();
        return data2;
    }

//    public void createStockOpname(StockOpnameRequest stockOpnameRequest) {
//
//        StockOpname newStockOpname = new StockOpname();
//        newStockOpname.setStatus(stockOpnameRequest.getStatus());
//        for (SKURequest SKU : stockOpnameRequest.getSKUs()) {
//            SKU newSKU = new SKU();
//            newSKU.setItemName(SKU.getItemName());
//            newSKU.setDeviationQty(SKU.getDeviationQty());
//            newSKU.setInformation(SKU.getInformation());
//            newSKU.setStockType(SKU.getStockType());
//            newSKU.setStorageCode(SKU.getStorageCode());
//            newSKU.setPhysicalQty(SKU.getPhysicalQty());
//            newSKU.setSystemQty(SKU.getSystemQty());
//            skuRepo.save(newSKU);
//        }
//        newStockOpname.countTotalQty();
//        newStockOpname.countTotalSKU();
//        newStockOpname.setWaktuPembuatan("");
//        stockOpnameRepo.save(newStockOpname);
//    }

    public void addUnknownSKUtoList (UnknownSKURequest unknownSKURequest) {

        UnknownSKU newUnknownSKU = new UnknownSKU();
        newUnknownSKU.setUnknownSKUId(unknownSKURequest.getUnknownSKUid());
        newUnknownSKU.setStorageCode(unknownSKURequest.getStorageCode());
        newUnknownSKU.setPhysicalQty(unknownSKURequest.getPhysicalQty());
        unknownSKURepo.save(newUnknownSKU);
        StockOpname st = stockOpnameRepo.findByStockOpnameId(unknownSKURequest.getStockOpnameId());
        newUnknownSKU.setStockOpname(st);
        unknownSKURepo.save(newUnknownSKU);

        List<UnknownSKU> uk = new ArrayList<>();
        uk.add(newUnknownSKU);
        st.setUnknownSKUs(uk);
//        st.addUnknownSKU(newUnknownSKU);




//
        stockOpnameRepo.save(st);





//        System.out.println("inilho"+us.size());
//
//        us.add(newUnknownSKU);
//
//        System.out.println("inilho"+us.size());
//
//
//        stockOpnameRepo.save(currentStockOpname);
//
//        System.out.println("inilho"+us.size());
//        System.out.println("inilho" + unknownSKURepo.findByStockOpname(currentStockOpname).size());
//
//
//        System.out.println("inilho" + unknownSKURepo.findByStockOpname(currentStockOpname).size());

    }
}


