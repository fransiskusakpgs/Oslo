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

    public void createStockOpname(StockOpnameRequest stockOpnameRequest) {

        StockOpname newStockOpname = new StockOpname();
        newStockOpname.setStockOpnameId(stockOpnameRequest.getStockOpnameId());
        newStockOpname.setStatus(stockOpnameRequest.getStatus());
        newStockOpname.setWaktuPembuatan(stockOpnameRequest.getWaktuPembuatan());
        newStockOpname.setTotalSKU(stockOpnameRequest.getSKUs().size());
        stockOpnameRepo.save(newStockOpname);
        List<SKU> SKUs = skuRepo.findByStockOpname(newStockOpname);

        int totalSKU = 0;
        for (SKU SKU: SKUs) { totalSKU += SKU.getSystemQty();}
    }
}


