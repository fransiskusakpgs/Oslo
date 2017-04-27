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
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockOpnameService {
    @Autowired
    StockOpnameRepository stockOpnameRepo;
    @Autowired
    SKURepository skuRepo;
    @Autowired
    UnknownSKURepository unknownSKURepo;
    @Autowired
    CounterRepository counterRepo;

    public List<StockOpname> findAll(){
        List<StockOpname> data2 = stockOpnameRepo.findAll();
        return data2;
    }
//
//    public void addUnknownSKUtoList (UnknownSKURequest unknownSKURequest) {
//        StockOpname currentStockOpname = stockOpnameRepo.findByStockOpnameId(unknownSKURequest.getStockOpnameId());
//        UnknownSKU newUnknownSKU = new UnknownSKU();
//        newUnknownSKU.setUnknownSKUId(unknownSKURequest.getUnknownSKUid());
//        newUnknownSKU.setStorageCode(unknownSKURequest.getStorageCode());
//        newUnknownSKU.setPhysicalQty(unknownSKURequest.getPhysicalQty());
//        unknownSKURepo.save(newUnknownSKU);
//        currentStockOpname.addUnknownSKU(newUnknownSKU);
//        currentStockOpname.countTotalQty();
//        currentStockOpname.countTotalSKU();
//        stockOpnameRepo.save(currentStockOpname);
//    }

    public void assignStockOpname(AssignmentRequest request){
        StockOpname currentStockOpname = stockOpnameRepo.findByStockOpnameId(
                request.getStockOpnameId());
        Counter currentCounter = counterRepo.findByUsername(
                request.getUsername());
        currentStockOpname.setAssignedTo(currentCounter);
        stockOpnameRepo.save(currentStockOpname);
        currentStockOpname.updateStatus();
        stockOpnameRepo.save(currentStockOpname);
    }

    public void createStockOpname(StockOpnameRequest stockOpnameRequest) {

        StockOpname newStockOpname = new StockOpname();
        newStockOpname.setStockOpnameId(stockOpnameRequest.getStockOpnameId());
        newStockOpname.setStatus(stockOpnameRequest.getStatus());
        LocalDate time = new LocalDate();
        newStockOpname.setWaktuPembuatan(time);
        int totalSKU = 0;
        List<SKU> SKUs = skuRepo.findByStockOpname(newStockOpname);
        for (SKU SKU: SKUs) { totalSKU += SKU.getSystemQty();}
        stockOpnameRepo.save(newStockOpname);
    }

    public List<StockOpname> findAllStockOpname(){
        List<StockOpname> data = stockOpnameRepo.findAll();
        return data;
    }

    public void unAssignStockOpname(AssignmentRequest request){
        StockOpname selectedStockOpname = stockOpnameRepo.findByStockOpnameId(request.getStockOpnameId());
        selectedStockOpname.unAssignStockOpname();
        stockOpnameRepo.save(selectedStockOpname);
    }
}


