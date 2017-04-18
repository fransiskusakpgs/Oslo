package com.bliblifuture.service;

import com.bliblifuture.model.SKU;
import com.bliblifuture.model.StockOpname;
import com.bliblifuture.model.UnknownSKU;
import com.bliblifuture.repository.SKURepository;
import com.bliblifuture.repository.StockOpnameRepository;
import com.bliblifuture.repository.UnknownSKURepository;
import com.bliblifuture.request.SingleRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SKUService {
    @Autowired
    SKURepository SKUrepo;
    @Autowired
    StockOpnameRepository stockOpnameRepo;

    public List<SKU> findSKUByStockOpname(){ //data request udah dipassing disini

        String activeStockOpname = "100" ;
        StockOpname a = stockOpnameRepo.findByStockOpnameId(activeStockOpname);

        List<SKU> data12 = SKUrepo.findByStockOpname(a);

        return data12;

    }

    }