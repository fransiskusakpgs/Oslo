package com.bliblifuture.service;

import com.bliblifuture.model.SKU;
import com.bliblifuture.model.StockOpname;
import com.bliblifuture.model.UnknownSKU;
import com.bliblifuture.repository.SKURepository;
import com.bliblifuture.repository.StockOpnameRepository;
import com.bliblifuture.repository.UnknownSKURepository;
import com.bliblifuture.request.SingleRequest;
import com.bliblifuture.request.UnknownSKURequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@Service
public class UnknownSKUService {

    @Autowired
    UnknownSKURepository unknownSKURepo;
    @Autowired
    StockOpnameRepository stockOpnameRepo;


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
        stockOpnameRepo.save(st);
    }

    public List<UnknownSKU> findUnknownSKUByStockOpname(String id){ //data request udah dipassing disini

        StockOpname a = stockOpnameRepo.findByStockOpnameId(id);
        List<UnknownSKU> data12 = unknownSKURepo.findByStockOpname(a);
        return data12;
    }


}
