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
import java.util.StringTokenizer;

@Service
public class UnknownSKUService {

    @Autowired
    UnknownSKURepository UnknownSKUrepo;
    @Autowired
    StockOpnameRepository stockOpnameRepo;

//    public List<UnknownSKU> findUnknownSKUByStockOpname(SingleRequest request){ //data request udah dipassing disini
//
//        StockOpname a = stockOpnameRepo.findByStockOpnameId(request.getData());
//
//        List<UnknownSKU> data12 = UnknownSKUrepo.findByStockOpname(a);
//
//        return data12;
//    }

    public List<UnknownSKU> findUnknownSKUByStockOpname(String id){ //data request udah dipassing disini

        StockOpname a = stockOpnameRepo.findByStockOpnameId(id);
        List<UnknownSKU> data12 = UnknownSKUrepo.findByStockOpname(a);
        return data12;
    }


}
