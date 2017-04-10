package com.bliblifuture.service;

import com.bliblifuture.model.SKU;
import com.bliblifuture.model.StockOpname;
import com.bliblifuture.model.UnknownSKU;
import com.bliblifuture.repository.SKURepository;
import com.bliblifuture.repository.StockOpnameRepository;
import com.bliblifuture.request.SKURequest;
import com.bliblifuture.request.StockOpnameRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockOpnameService {
    @Autowired
    StockOpnameRepository stockOpnameRepo;
    @Autowired
    SKURepository skuRepo;



    public List<StockOpname> findAll(){
        List<StockOpname> data = stockOpnameRepo.findAll();
        return data;
    }
    public void createStockOpname(StockOpnameRequest stockOpnameRequest)
    {

        StockOpname newStockOpname = new StockOpname();
        newStockOpname.setStatus(stockOpnameRequest.getStatus());

        for (SKURequest SKU: stockOpnameRequest.getSKUs()) {
            SKU newSKU = new SKU();
            newSKU.setItemName(SKU.getItemName());
            newSKU.setDeviationQty(SKU.getDeviationQty());
            newSKU.setInformation(SKU.getInformation());
            newSKU.setStockType(SKU.getStockType());
            newSKU.setStorageCode(SKU.getStorageCode());
            newSKU.setPhysicalQty(SKU.getPhysicalQty());
            newSKU.setSystemQty(SKU.getSystemQty());
            skuRepo.save(newSKU);
        }

        newStockOpname.countTotalQty();
        newStockOpname.countTotalSKU();
        newStockOpname.setWaktuPembuatan("");
        stockOpnameRepo.save(newStockOpname);

//
//        UnknownSKU unknownSKUone = new UnknownSKU();
//        unknownSKUone.setStorageCode("B-101-100");
//        unknownSKUone.setPhysicalQty(1);
//        unknownSKURepo.save(unknownSKUone);

    }

}
