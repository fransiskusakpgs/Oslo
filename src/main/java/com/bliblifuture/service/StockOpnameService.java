package com.bliblifuture.service;

import com.bliblifuture.model.Counter;
import com.bliblifuture.model.SKU;
import com.bliblifuture.model.StockOpname;
import com.bliblifuture.model.UnknownSKU;
import com.bliblifuture.repository.*;
import com.bliblifuture.request.AssignmentRequest;
import com.bliblifuture.request.SKURequest;
import com.bliblifuture.request.StockOpnameRequest;
import com.bliblifuture.request.UnknownSKURequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StockOpnameService {
    @Autowired
    CounterRepository counterRepo;
    @Autowired
    StockOpnameRepository stockOpnameRepo;
    @Autowired
    SKURepository skuRepo;
    @Autowired
    UnknownSKURepository unknownSKURepo;


    public void addUnknownSKUtoList (UnknownSKURequest unknownSKURequest) {

        StockOpname currentStockOpname = stockOpnameRepo.findByStockOpnameId(unknownSKURequest.getStockOpnameId());
        UnknownSKU newUnknownSKU = new UnknownSKU();
        newUnknownSKU.setUnknownSKUId(unknownSKURequest.getUnknownSKUId());
        newUnknownSKU.setStorageCode(unknownSKURequest.getStorageCode());
        newUnknownSKU.setPhysicalQty(unknownSKURequest.getPhysicalQty());
        unknownSKURepo.save(newUnknownSKU);
        currentStockOpname.addUnknownSKU(newUnknownSKU);
        currentStockOpname.countTotalQty();
        currentStockOpname.countTotalSKU();
        stockOpnameRepo.save(currentStockOpname);
    }

    public void assignStockOpname(AssignmentRequest request){
        StockOpname currentStockOpname = stockOpnameRepo.findByStockOpnameId(
                request.getStockOpnameId());
        Counter currentCounter = counterRepo.findByUsername(
                request.getUsername());
        currentStockOpname.setAssignedTo(currentCounter);
        stockOpnameRepo.save(currentStockOpname);
    }

    public void createStockOpname(StockOpnameRequest stockOpnameRequest) {

        StockOpname newStockOpname = new StockOpname();
        newStockOpname.setStatus(stockOpnameRequest.getStatus());
        for (SKURequest SKU : stockOpnameRequest.getSKUs()) {
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
        Date time = new Date();
        newStockOpname.setWaktuPembuatan(time);
        stockOpnameRepo.save(newStockOpname);
    }

    public List<StockOpname> findAll(){
        List<StockOpname> data2 = stockOpnameRepo.findAll();
        return data2;
    }

}


